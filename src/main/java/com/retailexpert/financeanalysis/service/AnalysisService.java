package com.retailexpert.financeanalysis.service;

import com.retailexpert.financeanalysis.common.ShipTypesEnum;
import com.retailexpert.financeanalysis.common.pojo.*;
import com.retailexpert.financeanalysis.db.entity.Price;
import com.retailexpert.financeanalysis.db.entity.Product;
import com.retailexpert.financeanalysis.db.repository.ActualRepository;
import com.retailexpert.financeanalysis.db.repository.PriceRepository;
import com.retailexpert.financeanalysis.db.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final ActualRepository actualRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductAnalysisResponsePojo getProductSalesAnalysis(ProductAnalysisRequestPojo request) {
        ProductAnalysisResponsePojo response = new ProductAnalysisResponsePojo();
        List<Date> datesForAnalysis = getMonthsBetweenBorders(request);
        response.setSalesMonths(mapDatesToMonthsPojo(datesForAnalysis));
        Calendar gc = new GregorianCalendar();
        for (SalesMonthPojo saleMonths : response.getSalesMonths()) {
            Date dateFrom = saleMonths.getMonth();
            gc.setTime(dateFrom);
            gc.add(Calendar.MONTH, 1);
            Date dateTo = gc.getTime();
            List<Long> materialNoList = actualRepository.getMaterialNoSalesInMonth(dateFrom, dateTo);
            List<ProductPojo> productSales = materialNoList.stream()
                    .map(mn -> getProductSales(dateFrom, dateTo, mn))
                    .toList();
            saleMonths.setProducts(productSales);
        }
        return response;
    }

    public FilteredProductSalesAnalysisResponse getFilteredProductSalesAnalysis(FilteredProductSalesAnalysisRequest request) {
        FilteredProductSalesAnalysisResponse response = new FilteredProductSalesAnalysisResponse();
        List<FilteredSalesProductPojo> products = mapFilteredProductsToPojoList(request);
        response.setProducts(products);
        return response;
    }

    private List<Date> getMonthsBetweenBorders(ProductAnalysisRequestPojo request) {
        List<Date> result = new ArrayList<>();
        Calendar gcFrom = new GregorianCalendar();
        Calendar gcTo = new GregorianCalendar();
        gcFrom.setTime(request.getMonthFrom());
        gcTo.setTime(request.getMonthTo());
        for (Calendar tempCalendar = gcFrom; tempCalendar.compareTo(gcTo) <= 0; tempCalendar.add(Calendar.MONTH, 1)) {
            result.add(tempCalendar.getTime());
        }
        return result;
    }

    private List<SalesMonthPojo> mapDatesToMonthsPojo(List<Date> dates) {
        return dates.stream()
                .map(d -> {
                    SalesMonthPojo pojo = new SalesMonthPojo();
                    pojo.setMonth(d);
                    return pojo;
                }).toList();
    }

    private ProductPojo getProductSales(Date dateFrom, Date dateTo, Long materialNo) {
        ProductPojo productPojo = new ProductPojo();
        List<Product> products = productRepository.findAllByMaterialNo(materialNo);
        productPojo.setMaterialNo(products.get(0).getMaterialNo());
        productPojo.setCategory(products.get(0).getL3ProductCategoryName());
        List<Price> pricesList = priceRepository.findAllByMaterialNo(materialNo);
        List<ChainSalePojo> chainSales = pricesList.stream()
                .map(p -> getProductSalesInChain(dateFrom, dateTo, p.getChainName(), materialNo))
                .toList();
        productPojo.setChainSales(chainSales);
        return productPojo;
    }

    private ChainSalePojo getProductSalesInChain(Date dateFrom, Date dateTo, String chainName, Long materialNo) {
        ChainSalePojo chainSalePojo = new ChainSalePojo();
        chainSalePojo.setChainName(chainName);
        Long sumOfSalesPromoVolume = mapToZeroIfNull(actualRepository.calculateSumOfSalesVolume(materialNo, chainName, ShipTypesEnum.PROMO_SHIP_TYPE.shipType, dateFrom, dateTo));
        Long sumOfSalesRegularVolume = mapToZeroIfNull(actualRepository.calculateSumOfSalesVolume(materialNo, chainName, ShipTypesEnum.REGULAR_SHIP_TYPE.shipType, dateFrom, dateTo));
        chainSalePojo.setPromoSellVolume(sumOfSalesPromoVolume);
        chainSalePojo.setRegularSellVolume(sumOfSalesRegularVolume);
        Long promoPercentage = 0L;
        if (sumOfSalesPromoVolume > 0 && sumOfSalesRegularVolume > 0) {
            promoPercentage = (sumOfSalesPromoVolume * 100) / (sumOfSalesPromoVolume + sumOfSalesRegularVolume);
        }
        chainSalePojo.setPromoPercentage(promoPercentage.intValue());
        return chainSalePojo;
    }

    private Long mapToZeroIfNull(Long value) {
        return value == null ? 0 : value;
    }

    private List<FilteredSalesProductPojo> mapFilteredProductsToPojoList(FilteredProductSalesAnalysisRequest request) {
        List<FilteredSalesProductPojo> result = request.getProductMaterialNoList().stream()
                .map(mn -> {
                    FilteredSalesProductPojo pojo = new FilteredSalesProductPojo();
                    pojo.setMaterialNo(mn);
                    pojo.setChains(getSalesInChains(mn, request.getChainNameList()));
                    return pojo;
                }).toList();
        return result;
    }

    private List<SalesChainPojo> getSalesInChains(Long materialNo, List<String> chainNames) {
        return chainNames.stream()
                .map(cn -> {
                    SalesChainPojo pojo = new SalesChainPojo();
                    pojo.setChainName(cn);
                    pojo.setSalesFacts(getSalesFacts(materialNo, cn));
                    return pojo;
                }).toList();
    }

    private List<SalesFactsPojo> getSalesFacts(Long materialNo, String chainName) {
        List<Date> salesDates = actualRepository.getSalesFactsDatesByMaterialNoAndChainName(materialNo, chainName);
        List<SalesFactsPojo> result = salesDates.stream()
                .map(sd -> {
                    SalesFactsPojo pojo = new SalesFactsPojo();
                    pojo.setDate(sd);
                    pojo.setVolume(mapToZeroIfNull(actualRepository.calculateProductSalesVolumeByDateInChain(sd, chainName, materialNo)));
                    pojo.setAmount(actualRepository.calculateSalesAmount(sd, chainName, materialNo));
                    return pojo;
                }).toList();
        return result;
    }
}

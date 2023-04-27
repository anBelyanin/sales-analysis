package com.retailexpert.financeanalysis.service;

import com.retailexpert.financeanalysis.common.pojo.PricesListResponsePojo;
import com.retailexpert.financeanalysis.common.pojo.PricePojo;
import com.retailexpert.financeanalysis.db.entity.Price;
import com.retailexpert.financeanalysis.db.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private final PriceRepository priceRepository;

    public PricesListResponsePojo getAllPrices() {
        List<Price> prices = priceRepository.findAll();
        return mapPriceEntityListToPojo(prices);
    }

    public PricesListResponsePojo getPricesByMaterialNo(Long materialNo) {
        List<Price> prices = priceRepository.findAllByMaterialNo(materialNo);
        return mapPriceEntityListToPojo(prices);
    }

    public PricesListResponsePojo getPricesByChainAndMaterialNo(String chainName, Long materialNo) {
        List<Price> prices = priceRepository.findAllByChainNameAndMaterialNo(chainName, materialNo);
        return mapPriceEntityListToPojo(prices);
    }

    public PricesListResponsePojo createNewPrice(PricePojo request) {
        Price price = new Price();
        price.setChainName(request.getChainName());
        price.setMaterialNo(request.getMaterialNo());
        price.setRegularPricePerUnit(request.getRegularPricePerUnit());
        priceRepository.save(price);
        return getPricesByChainAndMaterialNo(request.getChainName(), request.getMaterialNo());
    }

    public PricesListResponsePojo deletePriceByMaterialNo(Long materialNo) {
        List<Price> prices = priceRepository.findAllByMaterialNo(materialNo);
        priceRepository.deleteAll(prices);
        return mapPriceEntityListToPojo(prices);
    }

    public PricesListResponsePojo updatePrice(PricePojo pricePojo) {
        Price price = priceRepository.findById(pricePojo.getId())
                .orElseThrow(() -> new IllegalArgumentException("By this id not enough price"));
        price.setRegularPricePerUnit(pricePojo.getRegularPricePerUnit());
        price.setMaterialNo(pricePojo.getMaterialNo());
        price.setChainName(pricePojo.getChainName());
        priceRepository.save(price);
        return mapPriceEntityListToPojo(List.of(price));
    }

    private PricePojo mapPriceEntityToPojo(Price priceEntity) {
        PricePojo pojo = new PricePojo();
        pojo.setId(priceEntity.getId());
        pojo.setMaterialNo(priceEntity.getMaterialNo());
        pojo.setRegularPricePerUnit(priceEntity.getRegularPricePerUnit());
        pojo.setChainName(priceEntity.getChainName());
        return pojo;
    }

    private PricesListResponsePojo mapPriceEntityListToPojo(List<Price> pricesEntityList) {
        PricesListResponsePojo result = new PricesListResponsePojo();
        List<PricePojo> pricePojoList = pricesEntityList.stream()
                .map(this::mapPriceEntityToPojo).toList();
        result.setPrices(pricePojoList);
        return result;
    }

}

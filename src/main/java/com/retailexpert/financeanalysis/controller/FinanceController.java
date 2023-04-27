package com.retailexpert.financeanalysis.controller;

import com.retailexpert.financeanalysis.common.pojo.PricesListResponsePojo;
import com.retailexpert.financeanalysis.common.pojo.PricePojo;
import com.retailexpert.financeanalysis.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/finance")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeService;

    @GetMapping(path = "/price/get-all")
    public PricesListResponsePojo getAllPrices() {
        return financeService.getAllPrices();
    }

    @GetMapping(path = "/price/get-by-materialno")
    public PricesListResponsePojo getPricesByMaterialNo(@RequestParam Long materialNo) {
        return financeService.getPricesByMaterialNo(materialNo);
    }

    @GetMapping(path = "/price/get-by-chain-and-materialno")
    public PricesListResponsePojo getPricesByChainAndMaterial(@RequestParam String chainName,
                                                              @RequestParam Long materialNo) {
        return financeService.getPricesByChainAndMaterialNo(chainName, materialNo);
    }

    @PutMapping(path = "/price/create-new")
    public PricesListResponsePojo createNewPrice(PricePojo request) {
        return financeService.createNewPrice(request);
    }

    @DeleteMapping(path = "/price/delete-by-materialno")
    public PricesListResponsePojo deletePricesByMaterialNo(@RequestParam Long materialNo) {
        return financeService.deletePriceByMaterialNo(materialNo);
    }

    @PostMapping(path = "/price/update-by-id")
    public PricesListResponsePojo updatePrice(PricePojo request) {
        return financeService.updatePrice(request);
    }
}

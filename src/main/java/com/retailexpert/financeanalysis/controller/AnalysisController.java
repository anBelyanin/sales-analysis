package com.retailexpert.financeanalysis.controller;

import com.retailexpert.financeanalysis.common.pojo.FilteredProductSalesAnalysisRequest;
import com.retailexpert.financeanalysis.common.pojo.FilteredProductSalesAnalysisResponse;
import com.retailexpert.financeanalysis.common.pojo.ProductAnalysisRequestPojo;
import com.retailexpert.financeanalysis.common.pojo.ProductAnalysisResponsePojo;
import com.retailexpert.financeanalysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisService analysisService;

    @GetMapping(path = "/product-sales-analysis")
    public ProductAnalysisResponsePojo getSalesAnalysis(@RequestBody ProductAnalysisRequestPojo request) {
        return analysisService.getProductSalesAnalysis(request);
    }

    @GetMapping(path = "/product-sales-filtered")
    public FilteredProductSalesAnalysisResponse getFilteredSalesAnalysis(@RequestBody FilteredProductSalesAnalysisRequest request) {
        return analysisService.getFilteredProductSalesAnalysis(request);
    }
}

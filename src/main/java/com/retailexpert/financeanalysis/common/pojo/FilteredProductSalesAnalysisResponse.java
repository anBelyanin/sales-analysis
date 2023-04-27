package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "products"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FilteredProductSalesAnalysisResponse {

    @JsonProperty(value = "products")
    private List<FilteredSalesProductPojo> products;

}
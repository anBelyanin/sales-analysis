package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "chainNameList",
        "productMaterialNoList"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FilteredProductSalesAnalysisRequest {

    @JsonProperty(value = "chainNameList")
    private List<String> chainNameList;

    @JsonProperty(value = "productMaterialNoList")
    private List<Long> productMaterialNoList;

}

package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "materialNo",
        "chainSales",
        "category"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductPojo {

    @JsonProperty(value = "materialNo")
    private Long materialNo;

    @JsonProperty(value = "category")
    private String category;

    @JsonProperty(value = "chainSales")
    private List<ChainSalePojo> chainSales;

}

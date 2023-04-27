package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "products"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthPojo {

    @JsonProperty(value = "products")
    private List<ProductPojo> products;

}

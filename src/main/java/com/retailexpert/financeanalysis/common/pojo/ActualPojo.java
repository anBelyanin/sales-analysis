package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "chainName",
        "category",
        "month",
        "regularSellFacts",
        "promoSellFacts",
        "promoPercentage"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ActualPojo {

    @JsonProperty(value = "chainName")
    private String chainName;

    @JsonProperty(value = "category")
    private String category;

    @JsonProperty(value = "month")
    private String month;
}

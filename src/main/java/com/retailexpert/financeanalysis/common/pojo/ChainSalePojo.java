package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@JsonPropertyOrder({
        "chainName",
        "regularSellVolume",
        "promoSellVolume",
        "promoPercentage"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ChainSalePojo {

    @JsonProperty(value = "chainName")
    private String chainName;

    @JsonProperty(value = "regularSellVolume")
    private Long regularSellVolume;

    @JsonProperty(value = "promoSellVolume")
    private Long promoSellVolume;

    @JsonProperty(value = "promoPercentage")
    private Integer promoPercentage;
}

package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "materialNo",
        "month",
        "regularSellVolume",
        "promoSellVolume",
        "promoPercentage",
        "chainSales"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductPojo {

    @JsonProperty(value = "materialNo")
    private Long materialNo;

    @JsonProperty(value = "month")
    private String month;

    @JsonProperty(value = "regularSellVolume")
    private Long regularSellVolume;

    @JsonProperty(value = "promoSellVolume")
    private Long promoSellVolume;

    @JsonProperty(value = "promoPercentage")
    private Integer promoPercentage;

    @JsonProperty(value = "chainSales")
    private List<ChainSalePojo> chainSales;

}

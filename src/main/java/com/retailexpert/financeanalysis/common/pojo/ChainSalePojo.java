package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "chainName",
        "regularSellVolume",
        "promoSellVolume",
        "promoPercentage"
})
public class ChainSalePojo {
}

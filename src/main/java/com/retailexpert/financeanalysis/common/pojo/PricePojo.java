package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@JsonPropertyOrder({
        "id",
        "chainName",
        "materialNo",
        "regularPricePerUnit"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PricePojo {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "chainName", required = true)
    private String chainName;

    @JsonProperty(value = "materialNo", required = true)
    private Long materialNo;

    @JsonProperty(value = "regularPricePerUnit", required = true)
    private BigDecimal regularPricePerUnit;

}

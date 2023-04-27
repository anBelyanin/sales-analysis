package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "chainName",
        "salesFacts"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class SalesChainPojo {

    @JsonProperty(value = "chainName")
    private String chainName;

    @JsonProperty(value = "salesFacts")
    private List<SalesFactsPojo> salesFacts;

}

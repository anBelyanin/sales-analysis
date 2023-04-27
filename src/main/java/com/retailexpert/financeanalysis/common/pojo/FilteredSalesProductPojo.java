package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "materialNo",
        "chains"
})
@Getter
@Setter
public class FilteredSalesProductPojo {

    @JsonProperty(value = "materialNo")
    private Long materialNo;

    @JsonProperty(value = "chains")
    private List<SalesChainPojo> chains;

}

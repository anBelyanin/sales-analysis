package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonPropertyOrder({
        "month",
        "products"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class SalesMonthPojo {

    @JsonProperty(value = "month")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    private Date month;

    @JsonProperty(value = "products")
    private List<ProductPojo> products;

}

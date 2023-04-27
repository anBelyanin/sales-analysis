package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "date",
        "volume",
        "amount"
})
@Getter
@Setter
public class SalesFactsPojo {

    @JsonProperty(value = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @JsonProperty(value = "volume")
    private Long volume;

    @JsonProperty(value = "amount")
    private BigDecimal amount;

}

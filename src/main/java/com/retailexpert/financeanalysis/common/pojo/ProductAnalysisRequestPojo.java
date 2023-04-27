package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonPropertyOrder({
        "dateFrom",
        "dateTo"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductAnalysisRequestPojo {

    @JsonProperty(value = "dateFrom")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dateFrom;

    @JsonProperty(value = "dateTo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dateTo;

}

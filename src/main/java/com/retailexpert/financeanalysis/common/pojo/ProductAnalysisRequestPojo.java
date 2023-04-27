package com.retailexpert.financeanalysis.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonPropertyOrder({
        "monthFrom",
        "monthTo"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductAnalysisRequestPojo {

    @JsonProperty(value = "monthFrom")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    private Date monthFrom;

    @JsonProperty(value = "monthTo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    private Date monthTo;

}

package com.retailexpert.financeanalysis.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "actuals")
@Getter
@Setter
public class Actual {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "material_no")
    private Long materialNo;

    @Column(name = "ch3_ship_to_code")
    private String ch3ShipToCode;

    @Column(name = "chain_name")
    private String chainName;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "actual_sales_value")
    private BigDecimal actualSalesValue;

    @Column(name = "ship_type")
    private String shipType;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

}

package com.retailexpert.financeanalysis.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "price")
@Getter
@Setter
public class Price {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "chain_name")
    private String chainName;

    @Column(name = "material_no")
    private Long materialNo;

    @Column(name = "regular_price_per_unit")
    private BigDecimal regularPricePerUnit;

}

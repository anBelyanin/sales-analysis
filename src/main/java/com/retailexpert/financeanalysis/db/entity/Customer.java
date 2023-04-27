package com.retailexpert.financeanalysis.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ch3_ship_to_code")
    private Long ch3ShipToCode;

    @Column(name = "ch3_ship_to_name")
    private String ch3ShipToName;

    @Column(name = "chain_name")
    private String chainName;

}

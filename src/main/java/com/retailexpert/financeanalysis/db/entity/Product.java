package com.retailexpert.financeanalysis.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "material_no")
    private Long materialNo;

    @Column(name = "material_desc_rus")
    private String materialDescRus;

    @Column(name = "l3_product_category_code")
    private Long l3ProductCategoryCode;

    @Column(name = "l3_product_category_name")
    private Long l3ProductCategoryName;

    @Transient
    @OneToMany(mappedBy = "material_no", targetEntity = Price.class, fetch = FetchType.EAGER)
    private List<Price> priceList;

}

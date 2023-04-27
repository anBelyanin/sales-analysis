package com.retailexpert.financeanalysis.db.repository;

import com.retailexpert.financeanalysis.db.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findAllByMaterialNo(Long materialNo);
}

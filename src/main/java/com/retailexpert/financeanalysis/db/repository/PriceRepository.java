package com.retailexpert.financeanalysis.db.repository;

import com.retailexpert.financeanalysis.db.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findAll();

    List<Price> findAllByMaterialNo(Long materialNo);

    List<Price> findAllByChainNameAndMaterialNo(String chainName, Long materialNo);


}

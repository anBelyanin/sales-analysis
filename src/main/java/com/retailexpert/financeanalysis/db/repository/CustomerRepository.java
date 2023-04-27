package com.retailexpert.financeanalysis.db.repository;

import com.retailexpert.financeanalysis.db.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

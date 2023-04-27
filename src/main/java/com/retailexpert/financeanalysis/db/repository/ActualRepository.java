package com.retailexpert.financeanalysis.db.repository;

import com.retailexpert.financeanalysis.db.entity.Actual;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActualRepository extends CrudRepository<Actual, Long> {

    List<Actual> findAllByShipType(String shipType);

    @Query(value = "SELECT SUM(volume) FROM Actual WHERE (shipType = :shipType AND materialNo = :materialNo AND chainName = :chainName) AND date between :dateFrom and :dateTo")
    Long calculateSumOfSalesVolume(@Param("materialNo") Long materialNo,
                                   @Param("chainName") String chainName,
                                   @Param("shipType") String shipType,
                                   @Param("dateFrom") Date dateFrom,
                                   @Param("dateTo") Date dateTo);

    @Query(value = "SELECT SUM(actualSalesValue) FROM Actual WHERE (shipType = :shipType AND materialNo = :materialNo AND chainName = :chainName) AND date between :dateFrom and :dateTo")
    Long calculateSumOfSalesAmount(@Param("materialNo") Long materialNo,
                                   @Param("chainName") String chainName,
                                   @Param("shipType") String shipType,
                                   @Param("dateFrom") Date dateFrom,
                                   @Param("dateTo") Date dateTo);

}

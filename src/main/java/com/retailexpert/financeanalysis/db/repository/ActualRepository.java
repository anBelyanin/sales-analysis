package com.retailexpert.financeanalysis.db.repository;

import com.retailexpert.financeanalysis.db.entity.Actual;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ActualRepository extends CrudRepository<Actual, Long> {

    @Query(value = "SELECT SUM(volume) FROM Actual WHERE (shipType = :shipType AND materialNo = :materialNo AND chainName = :chainName) AND date between :dateFrom and :dateTo")
    Long calculateSumOfSalesVolume(@Param("materialNo") Long materialNo,
                                   @Param("chainName") String chainName,
                                   @Param("shipType") String shipType,
                                   @Param("dateFrom") Date dateFrom,
                                   @Param("dateTo") Date dateTo);

    @Query(value = "SELECT DISTINCT materialNo FROM Actual WHERE date between :dateFrom and :dateTo")
    List<Long> getMaterialNoSalesInMonth(@Param("dateFrom") Date dateFrom,
                                         @Param("dateTo") Date dateTo);

    @Query(value = "SELECT DISTINCT date FROM Actual WHERE materialNo = :materialNo AND chainName = :chainName ORDER BY date")
    List<Date> getSalesFactsDatesByMaterialNoAndChainName(@Param("materialNo") Long materialNo,
                                                     @Param("chainName") String chainName);

    @Query(value = "SELECT SUM(volume) FROM Actual WHERE date = :date AND chainName = :chainName AND materialNo = :materialNo")
    Long calculateProductSalesVolumeByDateInChain(@Param("date") Date date,
                                                  @Param("chainName") String chainName,
                                                  @Param("materialNo") Long materialNo);
    @Query(value = "SELECT SUM(actualSalesValue) FROM Actual WHERE date = :date AND chainName = :chainName AND materialNo = :materialNo")
    BigDecimal calculateSalesAmount(@Param("date") Date date,
                                    @Param("chainName") String chainName,
                                    @Param("materialNo") Long materialNo);

}

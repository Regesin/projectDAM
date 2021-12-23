package com.farmer.repository;/*
 *@created 23-12-2021/12/2021 - 02:33 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmNotFoundException;
import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.FarmDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFarmDetailsRepository extends JpaRepository<FarmDetails, Integer> {

    List<FarmDetails> findByAcres(double acres) throws FarmNotFoundException;

    List<FarmDetails> findByCity(String city) throws FarmNotFoundException;

    List<FarmDetails> findBySoil(String soil) throws FarmNotFoundException;

    List<FarmDetails> findByZipcode(String zipcode) throws FarmNotFoundException;

    @Query("from FarmDetails f where f.acres >= ?1 and f.city = ?2")
    List<FarmDetails> findByAcersCity(double acres, String city) throws FarmNotFoundException;

    @Query("from FarmDetails f where f.city = ?1 and f.soil = ?2")
    List<FarmDetails> findByCitySoil(String city, String soil) throws  FarmNotFoundException;

    @Query("from FarmDetails d where d.zipcode = ?1 and d.soil = ?2")
    List<FarmDetails> findByZipcodeSoil(String zipcode, String soil) throws FarmNotFoundException;
}

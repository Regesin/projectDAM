package com.farmer.repository;/*
 *@created 23-12-2021/12/2021 - 12:13 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {


    List<Farmer> findByGender(String gender);

    List<Farmer> findByAge(int age);

    @Query("from Farmer f where f.name like ?1%")
    List<Farmer> findByName(String name);

    @Query("from Farmer f where f.mobileNo like ?1%")
    List<Farmer> findByMobileNo(String mobileNo);

    @Query("from Farmer f where f.age between ?1 and ?2 ")
    List<Farmer> findByAgeBetween(int start, int end);
}

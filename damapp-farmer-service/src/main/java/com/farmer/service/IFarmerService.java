package com.farmer.service;/*
 *@created 23-12-2021/12/2021 - 12:01 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.Farmer;

import java.util.List;


public interface IFarmerService {

     void addFarmer(Farmer farmer);

     void updateFarmer(Farmer farmer) throws FarmerNotFoundException;

     void deleteFarmer(int farmerId) throws FarmerNotFoundException;

     List<Farmer> getAll();

     Farmer getById(int farmerId) throws FarmerNotFoundException;

     List<Farmer> getByName(String name) throws FarmerNotFoundException;

     List<Farmer> getByMobile(String mobileNo) throws FarmerNotFoundException;

     List<Farmer> getByGender(String gender) throws FarmerNotFoundException;

     List<Farmer> getByAge(int age) throws FarmerNotFoundException;

     List<Farmer> getByAgeBetween(int start, int end) throws FarmerNotFoundException;

     List<Object> getByFarmerId(int farmerId);
}

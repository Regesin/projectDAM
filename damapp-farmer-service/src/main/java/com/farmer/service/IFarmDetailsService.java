package com.farmer.service;/*
 *@created 23-12-2021/12/2021 - 12:25 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmNotFoundException;
import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.FarmDetails;

import java.util.List;


public interface IFarmDetailsService {

    void addFarm(FarmDetails farmDetails);

    void updateFarm(FarmDetails farmDetails);

    void deleteFarm(int farmId) throws FarmNotFoundException;

    List<FarmDetails> getAll() throws FarmNotFoundException;

    List<FarmDetails> getByAcres(double acres) throws FarmNotFoundException;

    List<FarmDetails> getByCity(String city) throws FarmNotFoundException;

    List<FarmDetails> getBySoil(String soil) throws FarmNotFoundException;

    List<FarmDetails> getBYZipcode(String zipcode) throws FarmNotFoundException;

    List<FarmDetails> getByAcersCity(double acres, String city) throws FarmerNotFoundException;

    List<FarmDetails> getByCitySoil(String city, String soil) throws  FarmerNotFoundException;

    List<FarmDetails> getByZipcodeSoil(String zipcode, String soil) throws FarmNotFoundException;


}

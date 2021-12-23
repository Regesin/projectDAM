package com.farmer.service;/*
 *@created 23-12-2021/12/2021 - 02:37 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmNotFoundException;
import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.FarmDetails;
import com.farmer.repository.IFarmDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmDetailsServiceImpl implements IFarmDetailsService {


    IFarmDetailsRepository farmDetailsRepository;

    public FarmDetailsServiceImpl(IFarmDetailsRepository farmDetailsRepository) {
        this.farmDetailsRepository = farmDetailsRepository;
    }

    @Override
    public void addFarm(FarmDetails farmDetails) {
        farmDetailsRepository.save(farmDetails);
    }

    @Override
    public void updateFarm(FarmDetails farmDetails) {
        farmDetailsRepository.save(farmDetails);

    }

    @Override
    public void deleteFarm(int farmId) throws FarmNotFoundException {
        farmDetailsRepository.deleteById(farmId);
    }

    @Override
    public List<FarmDetails> getAll() throws FarmNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findAll();
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("No Farms Exist in the Database");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getByAcres(double acres) throws FarmNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findByAcres(acres);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("Acers Not Found ");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getByCity(String city) throws FarmNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findByCity(city);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("City Not Found ");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getBySoil(String soil) throws FarmNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findBySoil(soil);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("Soil Not Found ");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getBYZipcode(String zipcode) throws FarmNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findByZipcode(zipcode);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("Zipcode Not Found ");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getByAcersCity(double acres, String city) throws FarmerNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findByAcersCity(acres, city);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("Acers and City Not Found Together");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getByCitySoil(String city, String soil) throws FarmerNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findByCitySoil(city, soil);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("City and Soil Not Found Together");
        return farmDetails;
    }

    @Override
    public List<FarmDetails> getByZipcodeSoil(String zipcode, String soil) throws FarmNotFoundException {
        List<FarmDetails> farmDetails = farmDetailsRepository.findByZipcodeSoil(zipcode, soil);
        if (farmDetails.isEmpty())
            throw new FarmNotFoundException("Zipcode and Soil Not Found Together");
        return farmDetails;
    }
}

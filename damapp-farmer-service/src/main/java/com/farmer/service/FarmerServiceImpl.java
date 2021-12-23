package com.farmer.service;/*
 *@created 23-12-2021/12/2021 - 12:14 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.Farmer;
import com.farmer.repository.IFarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerServiceImpl implements IFarmerService {

    IFarmerRepository farmerRepository;

    public FarmerServiceImpl(IFarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Override
    public void addFarmer(Farmer farmer) {
         farmerRepository.save(farmer);
    }

    @Override
    public void updateFarmer(Farmer farmer) throws FarmerNotFoundException {
         farmerRepository.save(farmer);
    }

    @Override
    public void deleteFarmer(int farmerId) throws FarmerNotFoundException {
        farmerRepository.deleteById(farmerId);
    }

    @Override
    public List<Farmer> getAll() {
        List<Farmer> farmers = farmerRepository.findAll();
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("No farmers existed");
        return farmers;
    }

    @Override
    public Farmer getById(int farmerId) throws FarmerNotFoundException {

        return farmerRepository.getById(farmerId);
    }

    @Override
    public List<Farmer> getByName(String name) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByName(name);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmer Name not found");
        return farmers;
    }

    @Override
    public List<Farmer> getByMobile(String mobileNo) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByMobileNo(mobileNo);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmer MobileNo not found");
        return farmers;
    }

    @Override
    public List<Farmer> getByGender(String gender) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByGender(gender);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException();
        return farmers;
    }

    @Override
    public List<Farmer> getByAge(int age) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByAge(age);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmers Age Not Found");
        return farmers;
    }

    @Override
    public List<Farmer> getByAgeBetween(int start, int end) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByAgeBetween(start, end);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmers Age between Not foun");
        return farmers;

    }
}

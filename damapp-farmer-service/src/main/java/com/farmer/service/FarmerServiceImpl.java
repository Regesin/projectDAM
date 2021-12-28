package com.farmer.service;/*
 *@created 23-12-2021/12/2021 - 12:14 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.Farmer;
import com.farmer.model.Gender;
import com.farmer.model.Produce;
import com.farmer.repository.IFarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class FarmerServiceImpl implements IFarmerService {
    public static final String BASEURL="http://ORDER-SERVICE/order-api";
    RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(@Lazy RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    IFarmerRepository farmerRepository;

    public FarmerServiceImpl(IFarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    /**
     *
     * @param farmer
     */
    @Override
    public void addFarmer(Farmer farmer) {
         farmerRepository.save(farmer);
    }

    /**
     *
     * @param farmer
     * @throws FarmerNotFoundException
     */
    @Override
    public void updateFarmer(Farmer farmer) throws FarmerNotFoundException {
         farmerRepository.save(farmer);
    }

    /**
     *
     * @param farmerId
     * @throws FarmerNotFoundException
     */
    @Override
    public void deleteFarmer(int farmerId) throws FarmerNotFoundException {
        farmerRepository.deleteById(farmerId);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Farmer> getAll() {
        List<Farmer> farmers = farmerRepository.findAll();
        return farmers;
    }

    /**
     *
     * @param farmerId farmerId from Farmer
     * @return Returns a Farmer found in the database
     * @throws FarmerNotFoundException If no farmer found in the database for the provided info
     */
    @Override
    public Farmer getById(int farmerId) throws FarmerNotFoundException {

        return farmerRepository.getById(farmerId);
    }

    /**
     *
     * @param name name from Farmer
     * @return Returns Farmers found in the database
     * @throws FarmerNotFoundException If no farmer found in the database for the provided info
     */
    @Override
    public List<Farmer> getByName(String name) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByName(name);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmer Name not found");
        return farmers;
    }

    /**
     *
     * @param mobileNo mobileNo from Farmer
     * @return Returns Farmers found in the database
     * @throws FarmerNotFoundException If no farmer found in the database for the provided info
     */
    @Override
    public List<Farmer> getByMobile(String mobileNo) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByMobileNo(mobileNo);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmer MobileNo not found");
        return farmers;
    }

    /**
     *
     * @param gender gender from Farmer
     * @return Returns Farmers found in the database
     * @throws FarmerNotFoundException If no farmer found in the database for the provided info
     */
    @Override
    public List<Farmer> getByGender(String gender) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByGender(Gender.valueOf(gender));
        if (farmers.isEmpty())
            throw new FarmerNotFoundException();
        return farmers;
    }

    /**
     *
     * @param age age from Farmer
     * @return Returns Farmers found in the database
     * @throws FarmerNotFoundException If no farmer found in the database for the provided info
     */
    @Override
    public List<Farmer> getByAge(int age) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByAge(age);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmers Age Not Found");
        return farmers;
    }

    /**
     *
     * @param start startDate from Farmer
     * @param end endDate from Farmer
     * @return Returns Farmers found in the database
     * @throws FarmerNotFoundException If no farmer found in the database for the provided info
     */
    @Override
    public List<Farmer> getByAgeBetween(int start, int end) throws FarmerNotFoundException {
        List<Farmer> farmers = farmerRepository.findByAgeBetween(start, end);
        if (farmers.isEmpty())
            throw new FarmerNotFoundException("Farmers Age between Not found");
        return farmers;

    }

    @Override
    public List<Object> getByFarmerId(int farmerId) {
        String url=BASEURL+"/orders/farmers/id/"+farmerId;
        List<Object> objects=restTemplate.getForObject(url,List.class);
        System.out.println(objects);
        return objects;

    }


}

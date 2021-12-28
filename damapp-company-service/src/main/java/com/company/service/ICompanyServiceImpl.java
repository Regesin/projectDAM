package com.company.service;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;

import com.company.model.Order;
import com.company.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ICompanyServiceImpl implements ICompanyService {

    public  static final String BASEURL="http://ORDER-SERVICE/order-api";
    RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(@Lazy RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    ICompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    /**
     *
     * @param company --> adding company object to the database
     * @return a newly added company oject
     */

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }


    /**
     *
     * @param company  --> updating a company object
     */
    @Override
    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    /**
     *
     * @param companyId --> deleting a company object by passing company Id
     */
    @Override
    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }

    /**
     *
     * @param companyId Company Id in Companies
     * @return company object based on company Id
     * @throws CompanyNotFoundException If no Company is found in the database for the provided company Id
     */
    @Override
    public Company getById(int companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException("Company not found"));
    }

    /**
     *
     * @return list of companies that are available in database
     */
    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    /**
     *
     * @param city
     * @return list of company objects based on city
     * @throws CompanyNotFoundException If no Company is found in the database for the provided info
     */
    @Override
    public List<Company> getByCity(String city) throws CompanyNotFoundException {
        List<Company> companies = companyRepository.findByCity(city);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    /**
     *
     * @param category
     * @return list of company objects based on Category
     * @throws CompanyNotFoundException If no Company is found in the database for the provided info
     */
    @Override
    public List<Company> getByCategory(String category) throws CompanyNotFoundException {
        List<Company> companies = companyRepository.findByCategory(category);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }
    /**
     *
     * @param state
     * @return list of company objects based on Category
     * @throws CompanyNotFoundException If no Company is found in the database for the provided info
     */

    @Override
    public List<Company> getByState(String state) {
        List<Company> companies = companyRepository.findByState(state);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }
    /**
     *
     * @param category
     * @param city
     * @return list of company objects based on Category and city
     * @throws CompanyNotFoundException If no Company is found in the database for the provided info
     */

    @Override
    public List<Company> getByCategoryAndCity(String category, String city) {
        List<Company> companies = companyRepository.findByCategoryAndCity(category, city);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }
    /**
     *
     * @param location
     * @return list of company objects based on location
     * @throws CompanyNotFoundException If no Company is found in the database for the provided info
     */

    @Override
    public List<Company> getByLocation(String location) {
        List<Company> companies = companyRepository.findByLocation(location);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    /**
     *
     * @param companyId Company Id in Companies
     * @return list of Orders that own by that company Id
     */
    @Override
    public List<Order> getByCompanyId(int companyId) {
        String url=BASEURL+"/order/companyId/"+companyId;
       List<Order> orders=restTemplate.getForObject(url,List.class);
        System.out.println(orders);
        return orders;
    }


}

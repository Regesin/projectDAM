package com.company.service;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;

import com.company.model.Order;
import com.company.repository.ICompanyRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
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

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }

    @Override
    public Company getById(int companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException("Company not found"));
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getByCity(String city) throws CompanyNotFoundException {
        List<Company> companies = companyRepository.findByCity(city);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    @Override
    public List<Company> getByCategory(String category) throws CompanyNotFoundException {
        List<Company> companies = companyRepository.findByCategory(category);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    @Override
    public List<Company> getByState(String state) {
        List<Company> companies = companyRepository.findByState(state);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    @Override
    public List<Company> getByCategoryAndCity(String category, String city) {
        List<Company> companies = companyRepository.findByCategoryAndCity(category, city);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    @Override
    public List<Company> getByLocation(String location) {
        List<Company> companies = companyRepository.findByLocation(location);
        if (companies.isEmpty()) {
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    @Override
    public List<Order> getByCompanyId(int companyId) {
        String url=BASEURL+"/order/companyId/"+companyId;
       List<Order> orders=restTemplate.getForObject(url,List.class);
        System.out.println(orders);
        return orders;
    }


}

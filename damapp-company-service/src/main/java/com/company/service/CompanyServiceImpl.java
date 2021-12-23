package com.company.service;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;
import com.company.repository.ICompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService{

    ICompanyRepository companyRepository;

    public CompanyServiceImpl(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

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
        return companyRepository.findById(companyId).orElseThrow(()->new CompanyNotFoundException("Company not found"));
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getByCity(String city) throws CompanyNotFoundException {
        List<Company> companies=companyRepository.findByCity(city);
        if (companies.isEmpty()){
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }

    @Override
    public List<Company> getByCategory(String category) throws CompanyNotFoundException {
         List<Company> companies=companyRepository.findByCategory(category);
        if (companies.isEmpty()){
            throw new CompanyNotFoundException("Companies not found");
        }
        return companies;
    }
}

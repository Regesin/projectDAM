package com.company.service;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;

import java.util.List;

public interface ICompanyService {
    public Company addCompany(Company company);
    public void updateCompany(Company company);
    public void deleteCompany(int companyId);
    public Company getById(int companyId) throws CompanyNotFoundException;
    public List<Company> getAll();
    public List<Company> getByCity(String city) throws CompanyNotFoundException;
    public List<Company> getByCategory(String category) throws CompanyNotFoundException;
}
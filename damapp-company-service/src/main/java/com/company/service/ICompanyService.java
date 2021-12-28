package com.company.service;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;
import com.company.model.Order;

import java.util.List;

public interface ICompanyService {

    public Company addCompany(Company company);

    public void updateCompany(Company company);



    public void deleteCompany(int companyId);



    public Company getById(int companyId) throws CompanyNotFoundException;


    public List<Company> getAll();


    public List<Company> getByCity(String city) throws CompanyNotFoundException;



    public List<Company> getByCategory(String category) throws CompanyNotFoundException;


    public List<Company> getByState(String state) throws CompanyNotFoundException;;


    public List<Company> getByCategoryAndCity(String category, String city) throws CompanyNotFoundException;;


    public List<Company> getByLocation(String location) throws CompanyNotFoundException;



    public List<Order> getByCompanyId(int companyId) ;
}

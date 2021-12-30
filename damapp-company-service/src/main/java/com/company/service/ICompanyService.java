package com.company.service;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;
import com.company.model.Farmer;
import com.company.model.Order;
import com.company.model.Produce;

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
    //getByKind, getByProduce, getByType, getByProQuiBid, getByProFerti, getByStartDate, getByEndDate

    List<Produce> getByKind(String kind) ;

    List<Produce> getByProduce(String produce) ;

    List<Produce> getByType(String type) ;

    List<Produce> getByProQuiBid(String produce,double quintal, double bidPrice) ;

    List<Produce> getByProFerti(String produce,String fertilizer) ;

    List<Produce> getByStartDate(String startDate);
    List<Produce> getByEndDate(String endDate);
    List<Produce> getByPriceLessThan(double price);
    List<Produce> getByPriceBetween(double startPrice,double endPrice);
    List<Produce> getByTypeProduce(String type,String  produce);






}

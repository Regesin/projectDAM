package com.company.repository;

import com.company.exceptions.CompanyNotFoundException;
import com.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Integer> {
    public List<Company> findByCity(String city) throws CompanyNotFoundException;
    public List<Company> findByCategory(String category) throws CompanyNotFoundException;

}

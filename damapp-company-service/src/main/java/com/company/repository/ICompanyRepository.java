package com.company.repository;

import com.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {

    public List<Company> findByCity(String city);

    public List<Company> findByCategory(String category);

    public List<Company> findByState(String state);

    public List<Company> findByCategoryAndCity(String category, String city);

    public List<Company> findByLocation(String location);


}

package com.company;

import com.company.model.Category;
import com.company.model.Company;
import com.company.service.ICompanyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringProjectdamCompanyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectdamCompanyApplication.class, args);
    }
    ICompanyService companyService;

    public SpringProjectdamCompanyApplication(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void run(String... args) throws Exception {
        Company company= new Company("Allen Solly","Gandhi Road","Bangalore",645321,"Karnataka","7689543216", Category.CLOTHING);
        Company company1= new Company("Gokaldas Exports","Malleswaram","Bangalore",645321,"Karnataka","9872467534", Category.FRUITSELLER);
        Company company2= new Company("Mandi Rates","Amara Muzik","Chennai",653456,"Tamil Nadu","9872423765", Category.FRUITSELLER);
        Company company3= new Company("Deemart","Madhapoor","Hyderabad",123456,"Telangana","9873437534", Category.CLOTHING);
        Company company4= new Company("BroCode","Ameertpet","Hyderabad",123264,"Telangana","9872267534", Category.CLOTHING);

        companyService.addCompany(company);
       companyService.addCompany(company1);
        companyService.addCompany(company2);
        companyService.addCompany(company3);
        companyService.addCompany(company4);
    }
}

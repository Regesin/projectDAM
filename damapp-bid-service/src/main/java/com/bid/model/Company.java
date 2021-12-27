package com.bid.model;/*
 *@created 22-12-2021/12/2021 - 03:58 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="companies")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Company {
    @Id
    @Column(length = 20, name = "companyid")
    @GeneratedValue(generator = "company_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "company_seq", sequenceName = "company_sequence", initialValue = 1, allocationSize = 1)
    private  Integer companyId;

    private String name;

    private String location;

    private  String city;

    private double zipcode;

    private String state;

    @Column(unique = true, length = 10)
    private String mobile;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Company(String name, String location, String city, double zipcode, String state, String mobile, Category category) {
        this.name = name;
        this.location = location;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.mobile = mobile;
        this.category = category;
    }
}

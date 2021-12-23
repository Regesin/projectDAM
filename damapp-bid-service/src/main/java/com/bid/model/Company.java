package com.bid.model;/*
 *@created 22-12-2021/12/2021 - 03:58 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private String mobile;

    private Category category;


}

package com.produce.model;/*
 *@created 22-12-2021/12/2021 - 03:14 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "farmers")
public class Farmer {

    @Id
    @Column(length = 20, name = "farmerid")
    @GeneratedValue(generator = "farmer_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "farmer_seq", sequenceName = "farmer_sequence", initialValue = 1, allocationSize = 1)
    private Integer farmerId;

    private String name;

    private int age;

    private String gender;

    @Column(name="mobileno",length=10)
    private String mobileNo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="farmer_id")
    private Set<FarmDetails> farmDetails;

    public Farmer(String name, int age, String gender, String mobileNo, Set<FarmDetails> farmDetails) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.farmDetails = farmDetails;
    }
}

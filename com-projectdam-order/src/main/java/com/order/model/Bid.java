package com.order.model;/*
 *@created 22-12-2021/12/2021 - 04:09 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="bids")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bid {
    @Id
    @Column(name="bidid")
    private  Integer bidId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyid")
    private Company company;

    @Column(name="bidprice")
    private double bidPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produceid")
    private Produce produce;

}

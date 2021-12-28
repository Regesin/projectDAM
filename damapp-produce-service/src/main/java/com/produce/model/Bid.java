package com.produce.model;/*
 *@created 22-12-2021/12/2021 - 04:09 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="bids")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Bid {
    @Id
    @Column(length = 20, name = "bidid")
    @GeneratedValue(generator = "bid_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "bid_seq", sequenceName = "bid_sequence", initialValue = 1, allocationSize = 1)
    private  Integer bidId;

    @OneToOne
    @JoinColumn(name = "companyid")
    private Company company;

    @Column(name="bidprice")
    private double bidPrice;

    @OneToOne
    @JoinColumn(name = "produceid")
    private Produce produce;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    public Bid(Company company, double bidPrice, Produce produce, PaymentMode paymentMode) {
        this.company = company;
        this.bidPrice = bidPrice;
        this.produce = produce;
        this.paymentMode = paymentMode;
    }
}

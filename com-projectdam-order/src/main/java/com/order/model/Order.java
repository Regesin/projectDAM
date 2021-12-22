package com.order.model;/*
 *@created 22-12-2021/12/2021 - 04:16 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(length = 20, name = "ordersid")
    @GeneratedValue(generator = "order_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", initialValue = 1, allocationSize = 1)
    private Integer orderId;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bidid")
    private Bid bid;

    private String city;

    @Column(name = "paymentmode")
    private String paymentMode;

    @Column(name = "ordertotal")
    private double orderTotal;


}

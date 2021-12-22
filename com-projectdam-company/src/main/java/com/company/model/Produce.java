package com.company.model;/*
 *@created 22-12-2021/12/2021 - 03:33 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="produces")
@Getter
@Setter
public class Produce {
    @Id
    @Column(length = 20, name = "produceid")
    @GeneratedValue(generator = "produce_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "produce_seq", sequenceName = "produce_sequence", initialValue = 1, allocationSize = 1)
    private Integer produceId;

    private String produce;

    @Enumerated(EnumType.STRING)
    private Fertilizer fertilizer;

    private double quintal;

    @Column(name = "bidprice")
    private double bidPrice;

    private String kind;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime start;

    private LocalDateTime end;





}

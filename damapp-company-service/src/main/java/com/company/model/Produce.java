package com.company.model;/*
 *@created 22-12-2021/12/2021 - 03:33 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="produces")
@Getter
@Setter
@NoArgsConstructor
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

    public Produce(String produce, Fertilizer fertilizer, double quintal,
                   double bidPrice, String kind, Type type, LocalDateTime start, LocalDateTime end) {
        this.produce = produce;
        this.fertilizer = fertilizer;
        this.quintal = quintal;
        this.bidPrice = bidPrice;
        this.kind = kind;
        this.type = type;
        this.start = start;
        this.end = end;
    }
}

package com.company.model;/*
 *@created 22-12-2021/12/2021 - 03:33 PM
 *@project IntelliJ IDEA
 *@author  DivyasreeBandaru
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="produces")
@Getter
@Setter
@ToString
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

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;

    @Column(name = "starttime")
    private LocalTime startTime;

    @Column(name ="endtime")
    private LocalTime endTime;

    /**
     *
     * @param produce
     * @param fertilizer
     * @param quintal
     * @param bidPrice
     * @param kind
     * @param type
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     */

    public Produce(String produce, Fertilizer fertilizer, double quintal, double bidPrice, String kind, Type type, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.produce = produce;
        this.fertilizer = fertilizer;
        this.quintal = quintal;
        this.bidPrice = bidPrice;
        this.kind = kind;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

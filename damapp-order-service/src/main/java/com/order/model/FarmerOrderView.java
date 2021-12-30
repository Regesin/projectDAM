package com.order.model;/*
 *@created 28-12-2021/12/2021 - 04:31 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */


public interface FarmerOrderView {

//   private String datetime;
//   private double ordertotal;
//   private String payment_mode;
//   private String kind;
//   private String produce;
//   private double quintal;

    String getDATETIME();
    Double getORDERTOTAL();
    String getNAME();
    String getCITY();
    String getMOBILE();
    String getSTATE();
    String getPRODUCE();
    Double getQUINTAL();
    Integer getFARMER_ID();
}

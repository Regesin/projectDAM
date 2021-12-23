package com.farmer.exceptions;/*
 *@created 23-12-2021/12/2021 - 12:08 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class FarmerNotFoundException extends RuntimeException {
    public FarmerNotFoundException() {
    }

    public FarmerNotFoundException(String message) {
        super(message);
    }
}

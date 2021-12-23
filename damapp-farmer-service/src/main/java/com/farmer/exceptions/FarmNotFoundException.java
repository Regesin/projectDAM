package com.farmer.exceptions;/*
 *@created 23-12-2021/12/2021 - 02:26 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class FarmNotFoundException extends RuntimeException {
    public FarmNotFoundException() {
    }

    public FarmNotFoundException(String message) {
        super(message);
    }
}

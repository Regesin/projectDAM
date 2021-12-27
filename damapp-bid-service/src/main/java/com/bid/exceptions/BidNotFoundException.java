package com.bid.exceptions;/*
 *@created 27-12-2021/12/2021 - 01:58 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class BidNotFoundException extends RuntimeException {
    public BidNotFoundException() {
    }

    public BidNotFoundException(String message) {
        super(message);
    }
}

package com.order.exceptions;/*
 *@created 27-12-2021/12/2021 - 03:01 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}

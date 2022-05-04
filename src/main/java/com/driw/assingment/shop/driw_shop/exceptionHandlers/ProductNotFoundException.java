package com.driw.assingment.shop.driw_shop.exceptionHandlers;

public class ProductNotFoundException extends RuntimeException{
    private long product_id;

    public ProductNotFoundException(long product_id) {
        super();
        this.product_id = product_id;
    }
}

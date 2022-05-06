package com.driw.assingment.shop.driw_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProductPriceDTO {
    private int productId;
    private int quantity;
    private double price;

}

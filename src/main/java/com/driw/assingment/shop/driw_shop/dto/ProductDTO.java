package com.driw.assingment.shop.driw_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private long product_id;
    private String product_name;
    private int itemsPerCarton;
    private int cartonPrice;
}

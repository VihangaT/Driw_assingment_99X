package com.driw.assingment.shop.driw_shop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity(name = "product")
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int product_id;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private int itemsPerCarton;
    @Column(nullable = false)
    private int cartonPrice;
}

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
    private Long product_id;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private Integer itemsPerCarton;
    @Column(nullable = false)
    private Double cartonPrice;
}

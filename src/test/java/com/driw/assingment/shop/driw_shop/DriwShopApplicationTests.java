package com.driw.assingment.shop.driw_shop;

import com.driw.assingment.shop.driw_shop.controllers.ProductController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.Assert.assertThat;

@SpringBootTest
class DriwShopApplicationTests {
    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() {
        assertThat(productController).isNotNull();
    }

}

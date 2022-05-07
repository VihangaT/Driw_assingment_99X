package com.driw.assingment.shop.driw_shop.services.implementations;

import com.driw.assingment.shop.driw_shop.dto.ProductDTO;
import com.driw.assingment.shop.driw_shop.repositories.ProductRepository;
import com.driw.assingment.shop.driw_shop.services.interfaces.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplementationTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @Autowired
    public ProductServiceImplementationTest(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @Test
    void getAll() {
        List<ProductDTO> resultSet= productService.getAll();
        List<ProductDTO> expectedResultSet=new ArrayList<>();
        expectedResultSet.add(new ProductDTO(1,"Penguin-ears",20,175.0));
        expectedResultSet.add(new ProductDTO(2,"Horseshoe",5,825.0));
        for(int i = 0; i < resultSet.size(); i++)
        {
            assertEquals(expectedResultSet.get(i).getProductId(), resultSet.get(i).getProductId());
            assertEquals(expectedResultSet.get(i).getProductName(), resultSet.get(i).getProductName());
            assertEquals(expectedResultSet.get(i).getCartonPrice(), resultSet.get(i).getCartonPrice());
            assertEquals(expectedResultSet.get(i).getItemsPerCarton(), resultSet.get(i).getItemsPerCarton());
        }

    }
}
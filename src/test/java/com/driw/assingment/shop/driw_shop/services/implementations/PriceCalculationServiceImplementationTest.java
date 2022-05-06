package com.driw.assingment.shop.driw_shop.services.implementations;

import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;
import com.driw.assingment.shop.driw_shop.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceCalculationServiceImplementationTest{

    @Autowired
     ProductRepository productRepository;

    @Test
    void calculatePriceForProductNoOneAndQuantityFourty() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        ProductPriceDTO expectingPto=new ProductPriceDTO(1,40,350);
        ProductPriceDTO pto=priceCalculationServiceImplementation.calculatePrice(1,40);
        assertEquals(expectingPto.getProductId(),pto.getProductId());
        assertEquals(expectingPto.getQuantity(),pto.getQuantity());
        assertEquals(expectingPto.getPrice(),pto.getPrice());
    }

    @Test
    void calculatePriceForProductNoTwoAndQuantityFive() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        ProductPriceDTO expectingPto=new ProductPriceDTO(2,5,825.0);
        ProductPriceDTO pto=priceCalculationServiceImplementation.calculatePrice(2,5);
        assertEquals(expectingPto.getProductId(),pto.getProductId());
        assertEquals(expectingPto.getQuantity(),pto.getQuantity());
        assertEquals(expectingPto.getPrice(),pto.getPrice());
    }

    @Test
    void calculatePriceForProductNoTwoAndQuantitySix() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        ProductPriceDTO expectingPto=new ProductPriceDTO(2,6,1897.5);
        ProductPriceDTO pto=priceCalculationServiceImplementation.calculatePrice(2,6);
        assertEquals(expectingPto.getProductId(),pto.getProductId());
        assertEquals(expectingPto.getQuantity(),pto.getQuantity());
        assertEquals(expectingPto.getPrice(),pto.getPrice());
    }

    @Test
    void calculatePriceForProductNoOneAndQuantityThirtyFive() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        ProductPriceDTO expectingPto=new ProductPriceDTO(1,35,3587.5);
        ProductPriceDTO pto=priceCalculationServiceImplementation.calculatePrice(1,35);
        assertEquals(expectingPto.getProductId(),pto.getProductId());
        assertEquals(expectingPto.getQuantity(),pto.getQuantity());
        assertEquals(expectingPto.getPrice(),pto.getPrice());
    }

    @Test
    void calculatePriceForProductTwoOneAndQuantityThirtyFive() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        ProductPriceDTO expectingPto=new ProductPriceDTO(2,35,5197.5);
        ProductPriceDTO pto=priceCalculationServiceImplementation.calculatePrice(2,35);
        assertEquals(expectingPto.getProductId(),pto.getProductId());
        assertEquals(expectingPto.getQuantity(),pto.getQuantity());
        assertEquals(expectingPto.getPrice(),pto.getPrice());
    }

    @Test
    void calculatePriceForProductWithDiscountFourCartonsInProductIdOne() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        ProductPriceDTO expectingPto=new ProductPriceDTO(1,80,630.0);
        ProductPriceDTO pto=priceCalculationServiceImplementation.calculatePrice(1,80);
        assertEquals(expectingPto.getProductId(),pto.getProductId());
        assertEquals(expectingPto.getQuantity(),pto.getQuantity());
        assertEquals(expectingPto.getPrice(),pto.getPrice());
    }

    @SneakyThrows
    @Test
    void getPriceListerProductIdOne() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        String expectedJSON="[{\"productId\":1,\"quantity\":1,\"price\":227.5},{\"productId\":1,\"quantity\":2,\"price\":455.0},{\"productId\":1,\"quantity\":3,\"price\":682.5},{\"productId\":1,\"quantity\":4,\"price\":910.0},{\"productId\":1,\"quantity\":5,\"price\":1137.5},{\"productId\":1,\"quantity\":6,\"price\":1365.0},{\"productId\":1,\"quantity\":7,\"price\":1592.5},{\"productId\":1,\"quantity\":8,\"price\":1820.0},{\"productId\":1,\"quantity\":9,\"price\":2047.5},{\"productId\":1,\"quantity\":10,\"price\":2275.0},{\"productId\":1,\"quantity\":11,\"price\":2502.5},{\"productId\":1,\"quantity\":12,\"price\":2730.0},{\"productId\":1,\"quantity\":13,\"price\":2957.5},{\"productId\":1,\"quantity\":14,\"price\":3185.0},{\"productId\":1,\"quantity\":15,\"price\":3412.5},{\"productId\":1,\"quantity\":16,\"price\":3640.0},{\"productId\":1,\"quantity\":17,\"price\":3867.5},{\"productId\":1,\"quantity\":18,\"price\":4095.0},{\"productId\":1,\"quantity\":19,\"price\":4322.5},{\"productId\":1,\"quantity\":20,\"price\":175.0},{\"productId\":1,\"quantity\":21,\"price\":402.5},{\"productId\":1,\"quantity\":22,\"price\":630.0},{\"productId\":1,\"quantity\":23,\"price\":857.5},{\"productId\":1,\"quantity\":24,\"price\":1085.0},{\"productId\":1,\"quantity\":25,\"price\":1312.5},{\"productId\":1,\"quantity\":26,\"price\":1540.0},{\"productId\":1,\"quantity\":27,\"price\":1767.5},{\"productId\":1,\"quantity\":28,\"price\":1995.0},{\"productId\":1,\"quantity\":29,\"price\":2222.5},{\"productId\":1,\"quantity\":30,\"price\":2450.0},{\"productId\":1,\"quantity\":31,\"price\":2677.5},{\"productId\":1,\"quantity\":32,\"price\":2905.0},{\"productId\":1,\"quantity\":33,\"price\":3132.5},{\"productId\":1,\"quantity\":34,\"price\":3360.0},{\"productId\":1,\"quantity\":35,\"price\":3587.5},{\"productId\":1,\"quantity\":36,\"price\":3815.0},{\"productId\":1,\"quantity\":37,\"price\":4042.5},{\"productId\":1,\"quantity\":38,\"price\":4270.0},{\"productId\":1,\"quantity\":39,\"price\":4497.5},{\"productId\":1,\"quantity\":40,\"price\":350.0},{\"productId\":1,\"quantity\":41,\"price\":577.5},{\"productId\":1,\"quantity\":42,\"price\":805.0},{\"productId\":1,\"quantity\":43,\"price\":1032.5},{\"productId\":1,\"quantity\":44,\"price\":1260.0},{\"productId\":1,\"quantity\":45,\"price\":1487.5},{\"productId\":1,\"quantity\":46,\"price\":1715.0},{\"productId\":1,\"quantity\":47,\"price\":1942.5},{\"productId\":1,\"quantity\":48,\"price\":2170.0},{\"productId\":1,\"quantity\":49,\"price\":2397.5},{\"productId\":1,\"quantity\":50,\"price\":2625.0}]";
        ObjectMapper mapper = new ObjectMapper();
        List<ProductPriceDTO> ExpectedPriceList =Arrays.asList(mapper.readValue(expectedJSON, ProductPriceDTO[].class));
        List<ProductPriceDTO> priceList=priceCalculationServiceImplementation.getPriceList(1);
        
        if(ExpectedPriceList.size()==priceList.size()) {
            for(int i = 0; i < ExpectedPriceList.size(); i++)
            {
                assertEquals(ExpectedPriceList.get(i).getProductId(), priceList.get(i).getProductId());
                assertEquals(ExpectedPriceList.get(i).getQuantity(), priceList.get(i).getQuantity());
                assertEquals(ExpectedPriceList.get(i).getPrice(), priceList.get(i).getPrice());
            }

        }
    }
    @SneakyThrows
    @Test
    void getPriceListerProductIdTwo() {
        PriceCalculationServiceImplementation priceCalculationServiceImplementation=new PriceCalculationServiceImplementation(productRepository);
        String expectedJSON="[{\"productId\":2,\"quantity\":1,\"price\":1072.5},{\"productId\":2,\"quantity\":2,\"price\":2145.0},{\"productId\":2,\"quantity\":3,\"price\":3217.5},{\"productId\":2,\"quantity\":4,\"price\":4290.0},{\"productId\":2,\"quantity\":5,\"price\":825.0},{\"productId\":2,\"quantity\":6,\"price\":1897.5},{\"productId\":2,\"quantity\":7,\"price\":2970.0},{\"productId\":2,\"quantity\":8,\"price\":4042.5},{\"productId\":2,\"quantity\":9,\"price\":5115.0},{\"productId\":2,\"quantity\":10,\"price\":1650.0},{\"productId\":2,\"quantity\":11,\"price\":2722.5},{\"productId\":2,\"quantity\":12,\"price\":3795.0},{\"productId\":2,\"quantity\":13,\"price\":4867.5},{\"productId\":2,\"quantity\":14,\"price\":5940.0},{\"productId\":2,\"quantity\":15,\"price\":2475.0},{\"productId\":2,\"quantity\":16,\"price\":3547.5},{\"productId\":2,\"quantity\":17,\"price\":4620.0},{\"productId\":2,\"quantity\":18,\"price\":5692.5},{\"productId\":2,\"quantity\":19,\"price\":6765.0},{\"productId\":2,\"quantity\":20,\"price\":2970.0},{\"productId\":2,\"quantity\":21,\"price\":4042.5},{\"productId\":2,\"quantity\":22,\"price\":5115.0},{\"productId\":2,\"quantity\":23,\"price\":6187.5},{\"productId\":2,\"quantity\":24,\"price\":7260.0},{\"productId\":2,\"quantity\":25,\"price\":3712.5},{\"productId\":2,\"quantity\":26,\"price\":4785.0},{\"productId\":2,\"quantity\":27,\"price\":5857.5},{\"productId\":2,\"quantity\":28,\"price\":6930.0},{\"productId\":2,\"quantity\":29,\"price\":8002.5},{\"productId\":2,\"quantity\":30,\"price\":4455.0},{\"productId\":2,\"quantity\":31,\"price\":5527.5},{\"productId\":2,\"quantity\":32,\"price\":6600.0},{\"productId\":2,\"quantity\":33,\"price\":7672.5},{\"productId\":2,\"quantity\":34,\"price\":8745.0},{\"productId\":2,\"quantity\":35,\"price\":5197.5},{\"productId\":2,\"quantity\":36,\"price\":6270.0},{\"productId\":2,\"quantity\":37,\"price\":7342.5},{\"productId\":2,\"quantity\":38,\"price\":8415.0},{\"productId\":2,\"quantity\":39,\"price\":9487.5},{\"productId\":2,\"quantity\":40,\"price\":5940.0},{\"productId\":2,\"quantity\":41,\"price\":7012.5},{\"productId\":2,\"quantity\":42,\"price\":8085.0},{\"productId\":2,\"quantity\":43,\"price\":9157.5},{\"productId\":2,\"quantity\":44,\"price\":10230.0},{\"productId\":2,\"quantity\":45,\"price\":6682.5},{\"productId\":2,\"quantity\":46,\"price\":7755.0},{\"productId\":2,\"quantity\":47,\"price\":8827.5},{\"productId\":2,\"quantity\":48,\"price\":9900.0},{\"productId\":2,\"quantity\":49,\"price\":10972.5},{\"productId\":2,\"quantity\":50,\"price\":7425.0}]";
        ObjectMapper mapper = new ObjectMapper();
        List<ProductPriceDTO> ExpectedPriceList =Arrays.asList(mapper.readValue(expectedJSON, ProductPriceDTO[].class));
        List<ProductPriceDTO> priceList=priceCalculationServiceImplementation.getPriceList(2);

        if(ExpectedPriceList.size()==priceList.size()) {
            for(int i = 0; i < ExpectedPriceList.size(); i++)
            {
                assertEquals(ExpectedPriceList.get(i).getProductId(), priceList.get(i).getProductId());
                assertEquals(ExpectedPriceList.get(i).getQuantity(), priceList.get(i).getQuantity());
                assertEquals(ExpectedPriceList.get(i).getPrice(), priceList.get(i).getPrice());
            }

        }
    }
}
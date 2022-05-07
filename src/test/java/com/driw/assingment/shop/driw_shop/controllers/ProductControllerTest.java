package com.driw.assingment.shop.driw_shop.controllers;

import com.driw.assingment.shop.driw_shop.dto.ProductDTO;
import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;
import com.driw.assingment.shop.driw_shop.models.Product;
import com.driw.assingment.shop.driw_shop.services.interfaces.PriceCalculationService;
import com.driw.assingment.shop.driw_shop.services.interfaces.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class)
class ProductControllerTest {
    @MockBean
    private ProductService productService;

    @MockBean
    private PriceCalculationService priceCalculationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllItems() throws Exception {
        ProductDTO productOne=new ProductDTO(1L,"Penguin-ears",20,175.0);
        ProductDTO productTwo=new ProductDTO(2L,"Horseshoe",5,825.0);
        List<ProductDTO> MockproductList=new ArrayList<>();
        MockproductList.add(productOne);
        MockproductList.add(productTwo);
        String expectedJSON="[{\"productId\":1,\"productName\":\"Penguin-ears\",\"itemsPerCarton\":20,\"cartonPrice\":175.0},{\"productId\":2,\"productName\":\"Horseshoe\",\"itemsPerCarton\":5,\"cartonPrice\":825.0}]";
        String URL="/api/v1/product";
        Mockito.when(productService.getAll()).thenReturn(MockproductList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URL)
                .accept(MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(requestBuilder).andReturn();
            MockHttpServletResponse response=result.getResponse();
            String returnedJSON=response.getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            List<ProductDTO> expectedList = Arrays.asList(mapper.readValue(expectedJSON, ProductDTO[].class));
            List<ProductDTO> returnedList = Arrays.asList(mapper.readValue(returnedJSON, ProductDTO[].class));
            for(int i = 0; i < expectedList.size(); i++)
            {
                assertEquals(expectedList.get(i).getProductId(), returnedList.get(i).getProductId());
                assertEquals(expectedList.get(i).getItemsPerCarton(), returnedList.get(i).getItemsPerCarton());
                assertEquals(expectedList.get(i).getProductName(), returnedList.get(i).getProductName());
                assertEquals(expectedList.get(i).getCartonPrice(), returnedList.get(i).getCartonPrice());
            }

    }

    @Test
    void getPrice() throws Exception {
        ProductPriceDTO price=new ProductPriceDTO(1,40,350L);
        String URL="/api/v1/product/1/price?quantity=40";
        Mockito.when(priceCalculationService.calculatePrice(1,40)).thenReturn(price);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URL)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=result.getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    void getPriceList() throws Exception {
        ProductPriceDTO priceOne=new ProductPriceDTO(1,40,350L);
        ProductPriceDTO priceTwo=new ProductPriceDTO(1,20,175L);
        List<ProductPriceDTO> mocktList=new ArrayList<>();
        mocktList.add(priceOne);
        mocktList.add(priceTwo);
        String URL="/api/v1/product/1/price-list";
        Mockito.when(priceCalculationService.getPriceList(1)).thenReturn(mocktList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URL)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=result.getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
}
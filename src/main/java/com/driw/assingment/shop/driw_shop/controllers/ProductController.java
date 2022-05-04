package com.driw.assingment.shop.driw_shop.controllers;

import com.driw.assingment.shop.driw_shop.dto.ProductDTO;
import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;
import com.driw.assingment.shop.driw_shop.exceptionHandlers.ProductNotFoundException;
import com.driw.assingment.shop.driw_shop.services.interfaces.PriceCalculationService;
import com.driw.assingment.shop.driw_shop.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/product")
public class ProductController {

    private PriceCalculationService priceCalculationService;
    private ProductService productService;

    @Autowired
    public ProductController(PriceCalculationService priceCalculationService,ProductService productService){
        this.priceCalculationService=priceCalculationService;
        this.productService=productService;
    }

    @GetMapping("")
    ResponseEntity<List<ProductDTO>> getAllItems() {
        return ResponseEntity.ok(this.productService.getAll());
    }

//    http://localhost:8080/product/2/price?qty=10
    @GetMapping(value = "/{product_id}/price", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ProductPriceDTO> getPrice(@PathVariable int product_id, @RequestParam("quantity") int quantity) throws ProductNotFoundException {
        ProductPriceDTO itemPrice = priceCalculationService.calculatePrice(product_id, quantity);
        return ResponseEntity.ok(itemPrice);
    }

//    http://localhost:8080/product/1/price-list
    @GetMapping(value = "/{product_id}/price-list", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductPriceDTO>> getPriceList(@PathVariable int product_id) {
        return ResponseEntity.ok(priceCalculationService.getPriceList(product_id));
    }

}

package com.driw.assingment.shop.driw_shop.services.implementations;

import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;
import com.driw.assingment.shop.driw_shop.exceptionHandlers.ProductNotFoundException;
import com.driw.assingment.shop.driw_shop.models.Product;
import com.driw.assingment.shop.driw_shop.repositories.ProductRepository;
import com.driw.assingment.shop.driw_shop.services.interfaces.PriceCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PriceCalculationServiceImplementation implements PriceCalculationService {

    private ProductRepository productRepository;

    @Autowired
    public PriceCalculationServiceImplementation(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public ProductPriceDTO calculatePrice(int productId, int quantity) {
        Product product = productRepository.findById((long) productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        double price;
        int itemsPerCarton=product.getItemsPerCarton();
        double cartonPrice=product.getCartonPrice();
        if (quantity < itemsPerCarton) {
            price = 1.3 * cartonPrice * quantity;
        } else if (quantity == itemsPerCarton) {
            price = cartonPrice;
        } else {
            int numberOfCartons = quantity / itemsPerCarton;
            int noOfSingleUnits = quantity % itemsPerCarton;

            if (numberOfCartons > 3) {
                price = (numberOfCartons * cartonPrice) * 0.9;
            } else {
                price = numberOfCartons * cartonPrice;
            }

            if (noOfSingleUnits > 0) {
                price += noOfSingleUnits * cartonPrice * 1.3;
            }
        }
        return new ProductPriceDTO(productId, quantity, price);
    }

    @Override
    public List<ProductPriceDTO> getPriceList(int productId) {
        List<ProductPriceDTO> priceList = new ArrayList<>();

            Optional<Product> item = productRepository.findById((long) productId);
            if (item.isPresent()) {
                for (int i = 1; i <= 50; i++) {
                   priceList.add(new ProductPriceDTO(productId, i, calculatePrice(productId, i).getPrice()));
                }
            }
        return priceList;

    }
}

package com.driw.assingment.shop.driw_shop.services.implementations;

import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;
import com.driw.assingment.shop.driw_shop.exceptionHandlers.ProductNotFoundException;
import com.driw.assingment.shop.driw_shop.models.Product;
import com.driw.assingment.shop.driw_shop.repositories.ProductRepository;
import com.driw.assingment.shop.driw_shop.services.interfaces.PriceCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PriceCalculationServiceImplementation implements PriceCalculationService {

    private ProductRepository productRepository;

    public PriceCalculationServiceImplementation(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    @Override
    public ProductPriceDTO calculatePrice(int product_id, int quantity) {
        Product product = productRepository.findById((long) product_id)
                .orElseThrow(() -> new ProductNotFoundException(product_id));

        double price = 0;
        int itemsPerCarton=product.getItemsPerCarton();
        if (quantity < itemsPerCarton) {
            price = 1.3 * product.getCartonPrice() * quantity;
        } else if (quantity == itemsPerCarton) {
            price = product.getCartonPrice();
        } else if (quantity > itemsPerCarton) {
            int numberOfCartons = quantity / itemsPerCarton;
            int noOfSingleUnits = quantity % itemsPerCarton;

            if (numberOfCartons > 3) {
                price = (numberOfCartons * product.getCartonPrice()) * 0.9;
            } else {
                price = numberOfCartons * product.getCartonPrice();
            }

            if (noOfSingleUnits > 0) {
                price += noOfSingleUnits * product.getCartonPrice() * 1.3;
            }
        }
        return new ProductPriceDTO(product_id, quantity, price);
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

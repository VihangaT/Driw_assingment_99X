package com.driw.assingment.shop.driw_shop.services.implementations;

import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;
import com.driw.assingment.shop.driw_shop.exceptionHandlers.ProductNotFoundException;
import com.driw.assingment.shop.driw_shop.models.Product;
import com.driw.assingment.shop.driw_shop.repositories.ProductRepository;
import com.driw.assingment.shop.driw_shop.services.interfaces.PriceCalculationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationServiceImplementation implements PriceCalculationService {

    private ProductRepository productRepository;

    public PriceCalculationServiceImplementation(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    @Override
    public ProductPriceDTO calculatePrice(int product_id, int quantity) {
        Product item = productRepository.findById((long) product_id)
                .orElseThrow(() -> new ProductNotFoundException(product_id));;

        double price = 0;
        if (quantity < item.getItemsPerCarton()) {
            price = 1.3 * item.getCartonPrice() * quantity;
        } else if (quantity == item.getItemsPerCarton()) {
            price = item.getCartonPrice();
        } else if (quantity > item.getItemsPerCarton()) {
            int noOfCartons = quantity / item.getItemsPerCarton();
            int noOfSingleUnits = quantity % item.getItemsPerCarton();

            if (noOfCartons > 3) {
                price = (noOfCartons * item.getCartonPrice()) * 0.9;
            } else {
                price = noOfCartons * item.getCartonPrice();
            }

            if (noOfSingleUnits > 0) {
                price += noOfSingleUnits * item.getCartonPrice() * 1.3;
            }
        }
        return new ProductPriceDTO(product_id, quantity, price);
    }

    @Override
    public List<ProductPriceDTO> getPriceList(int itemId) {
        return null;
    }
}

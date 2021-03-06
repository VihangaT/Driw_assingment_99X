package com.driw.assingment.shop.driw_shop.services.implementations;

import com.driw.assingment.shop.driw_shop.dto.ProductDTO;
import com.driw.assingment.shop.driw_shop.repositories.ProductRepository;
import com.driw.assingment.shop.driw_shop.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(product -> new ProductDTO(product.getProductId(), product.getProductName(), product.getItemsPerCarton(), product.getCartonPrice()))
                .collect(Collectors.toList());
    }


}

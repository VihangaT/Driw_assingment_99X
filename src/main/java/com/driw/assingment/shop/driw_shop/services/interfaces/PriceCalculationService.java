package com.driw.assingment.shop.driw_shop.services.interfaces;

import com.driw.assingment.shop.driw_shop.dto.ProductDTO;
import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;

import java.util.List;

public interface PriceCalculationService {
    ProductPriceDTO  calculatePrice(int product_id,int quantity);
    List<ProductPriceDTO> getPriceList(int product_id);
}

package com.driw.assingment.shop.driw_shop.services.interfaces;


import com.driw.assingment.shop.driw_shop.dto.ProductPriceDTO;

import java.util.List;

public interface PriceCalculationService {
    ProductPriceDTO  calculatePrice(int productId,int quantity);
    List<ProductPriceDTO> getPriceList(int productId);
}

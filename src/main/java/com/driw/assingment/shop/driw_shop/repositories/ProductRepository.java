package com.driw.assingment.shop.driw_shop.repositories;

import com.driw.assingment.shop.driw_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}

package com.nequi.franchises.product.application.ports.out;


import com.nequi.franchises.product.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product getById(Long productId);
    Product save (Product product);
    void delete(Long productId);
}

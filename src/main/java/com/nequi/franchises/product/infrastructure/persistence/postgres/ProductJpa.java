package com.nequi.franchises.product.infrastructure.persistence.postgres;

import com.nequi.franchises.product.infrastructure.persistence.postgres.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpa extends JpaRepository<ProductModel, Long> {
}

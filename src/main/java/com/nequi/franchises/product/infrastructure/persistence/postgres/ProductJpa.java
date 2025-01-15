package com.nequi.franchises.product.infrastructure.persistence.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductJpa extends JpaRepository<ProductModel, Long> {

    @Query("SELECT p " +
            "FROM ProductModel p " +
            "WHERE p.stock = (" +
            "    SELECT MAX(p2.stock) " +
            "    FROM ProductModel p2 " +
            "    WHERE p2.branchId IN :branchId" +
            ") " +
            "ORDER BY p.branchId")
    List<ProductModel> findMaxStockProductsByFranchiseId(@Param("branchId") List<Long> branchId);
}

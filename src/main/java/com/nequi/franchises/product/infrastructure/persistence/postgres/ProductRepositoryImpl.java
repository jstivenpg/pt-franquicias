package com.nequi.franchises.product.infrastructure.persistence.postgres;

import com.nequi.franchises.product.application.mappers.ProductMapper;
import com.nequi.franchises.product.application.ports.out.ProductRepository;
import com.nequi.franchises.product.domain.Product;
import com.nequi.franchises.product.infrastructure.persistence.postgres.ProductJpa;
import com.nequi.franchises.product.infrastructure.persistence.postgres.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpa productJpa;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        List<ProductModel> productsModel = productJpa.findAll();

        return productMapper.productModelListToProduct(productsModel);
    }

    @Override
    public Product getById(Long productId) {
        ProductModel productModel = productJpa.findById(productId).orElse(null);

        return productMapper.productModelToProduct(productModel);
    }

    @Override
    public Product save(Product product) {
        ProductModel productModel = productMapper.productToProductModel(product);
        productJpa.save(productModel);

        return productMapper.productModelToProduct(productModel);
    }

    @Override
    public void delete(Long productId) {
        productJpa.deleteById(productId);
    }
}

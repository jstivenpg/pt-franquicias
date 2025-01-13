package com.nequi.franchises.product.domain;

import com.nequi.franchises.product.application.mappers.ProductMapper;
import com.nequi.franchises.product.application.ports.in.ProductService;
import com.nequi.franchises.product.application.ports.out.ProductRepository;
import com.nequi.franchises.product.infrastructure.web.dtos.ProductDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;
import com.nequi.franchises.shared.application.dtos.ResponseCode;
import com.nequi.franchises.shared.application.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductUseCase implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public GeneralResponse<List<ProductDTO>> getAllProducts() {
        List<Product> productsEntity = productRepository.findAll();
        List<ProductDTO> productsDto = productMapper.productListToDto(productsEntity);

        return new GeneralResponse<>(productsDto);
    }

    @Override
    public GeneralResponse<ProductDTO> getProductById(Long productId) {
        Product productEntity = productRepository.getById(productId);
        if (productEntity == null) {
            throw new ApiException(ResponseCode.PRODUCT_NOT_FOUND, productId);
        }

        ProductDTO productDto = productMapper.productToDto(productEntity);
        return new GeneralResponse<>(productDto);
    }

    @Override
    public GeneralResponse<ProductDTO> createProduct(ProductDTO product) {
        Product productEntity = productMapper.dtoToProduct(product);

        return new GeneralResponse<>(saveProduct(productEntity));
    }

    @Override
    public GeneralResponse<ProductDTO> updateProduct(Long productId, ProductDTO product) {
        Product productEntity = productRepository.getById(productId);

        productEntity.setProductId(productId);
        productEntity.setStock(product.stock());
        Optional.ofNullable(product.name()).ifPresent(productEntity::setName);

        return new GeneralResponse<>(saveProduct(productEntity));
    }

    @Override
    public void deleteProduct(Long productId) {
        try {
            productRepository.delete(productId);
        } catch (Exception e) {
            log.error("Error deleting product with id: {}", productId, e);
            throw new ApiException(ResponseCode.PRODUCT_NOT_DELETED, productId);
        }
    }

    private ProductDTO saveProduct(Product product) {
        try {
            return productMapper.productToDto(productRepository.save(product));
        } catch (Exception e) {
            log.error("Error saving product: {}", product, e);
            throw new ApiException(ResponseCode.UNEXPECTED_ERROR, e);
        }
    }
}

package com.nequi.franchises.product.application.ports.in;

import com.nequi.franchises.product.infrastructure.web.dtos.ProductDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;

import java.util.List;

public interface ProductService {
    GeneralResponse<List<ProductDTO>> getAllProducts();
    GeneralResponse<ProductDTO> getProductById(Long productId);
    GeneralResponse<ProductDTO> createProduct(ProductDTO product);
    GeneralResponse<ProductDTO> updateProduct(Long productId, ProductDTO product);
    void deleteProduct(Long productId);
}

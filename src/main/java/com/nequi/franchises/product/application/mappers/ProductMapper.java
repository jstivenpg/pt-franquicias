package com.nequi.franchises.product.application.mappers;

import com.nequi.franchises.product.domain.Product;
import com.nequi.franchises.product.infrastructure.persistence.postgres.ProductModel;
import com.nequi.franchises.product.infrastructure.web.dtos.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    // ProductEntity domain -> ProductDTO application and reverse
    Product dtoToProduct(ProductDTO productDTO);
    List<Product> dtoListToProduct(List<ProductDTO> productDTO);
    ProductDTO productToDto(Product product);
    List<ProductDTO> productListToDto(List<Product> product);

    // ProductEntity domain -> ProductModel adapter and reverse
    Product productModelToProduct(ProductModel productModel);
    List<Product> productModelListToProduct(List<ProductModel> productModel);
    ProductModel productToProductModel(Product product);
    List<ProductModel> productListToProductModel(List<Product> product);
}

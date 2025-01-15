package com.nequi.franchises.product.infrastructure.web.v1;

import com.nequi.franchises.product.application.ports.in.ProductService;
import com.nequi.franchises.product.infrastructure.web.dtos.ProductDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;
import com.nequi.franchises.shared.application.exceptions.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "products", description = "API to manage products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Find all products", tags = {"products", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product list"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<ProductDTO>> getAllProducts(){
        return productService.getAllProducts();
    }

    @Operation(summary = "Find a product by id", tags = {"products", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product get by id"),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<ProductDTO> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }


    @Operation(summary = "Find a product with maximum stock per branch and franchise",
            tags = {"products", "GET"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product with maximum stock per branch and franchise"),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @GetMapping("/franchise/{franchiseId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<ProductDTO>> getMaxStockProducts(@PathVariable Long franchiseId) {
        return productService.getMaxStockProductsByFranchiseId(franchiseId);
    }

    @Operation(summary = "Create a product", tags = {"products", "POST"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<ProductDTO> createProduct(@RequestBody ProductDTO product){
        return productService.createProduct(product);
    }

    @Operation(summary = "Update a product", tags = {"products", "PUT"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<ProductDTO> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO product){
        return productService.updateProduct(productId, product);
    }

    @Operation(summary = "Delete a product", tags = {"products", "DELETE"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))
            })
    })
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}

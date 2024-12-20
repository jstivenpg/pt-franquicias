package com.nequi.franchises.product.infrastructure.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record ProductDTO(
    @JsonProperty("product_id")
    Long productId,
    String name,
    @JsonProperty("created_at")
    ZonedDateTime createdAt,
    @JsonProperty("updated_at")
    ZonedDateTime updatedAt
) implements Serializable {
}

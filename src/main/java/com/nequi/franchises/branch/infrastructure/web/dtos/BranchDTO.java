package com.nequi.franchises.branch.infrastructure.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;
import com.nequi.franchises.product.infrastructure.web.dtos.ProductDTO;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

public record BranchDTO(
    @JsonProperty("branch_id")
    Long branchId,
    String name,
    FranchiseDTO franchise,
    Set<ProductDTO> products,
    @JsonProperty("created_at")
    ZonedDateTime createdAt,
    @JsonProperty("updated_at")
    ZonedDateTime updatedAt
) implements Serializable {
}

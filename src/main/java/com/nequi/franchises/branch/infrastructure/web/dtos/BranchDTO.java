package com.nequi.franchises.branch.infrastructure.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record BranchDTO(
    @JsonProperty("branch_id")
    Long branchId,
    String name,
    FranchiseDTO franchise,
    @JsonProperty("created_at")
    ZonedDateTime createdAt,
    @JsonProperty("updated_at")
    ZonedDateTime updatedAt
) implements Serializable {
}

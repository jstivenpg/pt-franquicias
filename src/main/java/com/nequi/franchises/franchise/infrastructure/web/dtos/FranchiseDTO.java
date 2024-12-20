package com.nequi.franchises.franchise.infrastructure.web.dtos;

import com.fasterxml.jackson.annotation.*;
import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

public record FranchiseDTO(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("franchise_id")
    Long franchiseId,
    String name,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Set<BranchDTO> branches,
    @JsonProperty("created_at")
    ZonedDateTime createdAt,
    @JsonProperty("updated_at")
    ZonedDateTime updatedAt
) implements Serializable {
}

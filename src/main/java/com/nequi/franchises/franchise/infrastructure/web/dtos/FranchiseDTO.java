package com.nequi.franchises.franchise.infrastructure.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record FranchiseDTO(
    @JsonProperty("franchise_id")
    Long franchiseId,
    String name,
    @JsonProperty("created_at")
    ZonedDateTime createdAt,
    @JsonProperty("updated_at")
    ZonedDateTime updatedAt
) implements Serializable {
}

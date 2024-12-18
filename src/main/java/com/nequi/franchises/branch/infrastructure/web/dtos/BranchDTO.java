package com.nequi.franchises.branch.infrastructure.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record BranchDTO(
    @JsonProperty("branch_id")
    Long branchId,
    String name,
    @JsonProperty("created_at")
    ZonedDateTime createdAt,
    @JsonProperty("updated_at")
    ZonedDateTime updatedAt
) implements Serializable {
}

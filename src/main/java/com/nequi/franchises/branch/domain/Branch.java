package com.nequi.franchises.branch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Branch implements Serializable {
    private Long branchId;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
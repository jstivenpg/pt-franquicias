package com.nequi.franchises.franchise.domain;

import com.nequi.franchises.branch.domain.Branch;
import com.nequi.franchises.branch.infrastructure.persistence.postgres.BranchModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Franchise implements Serializable {
    private Long franchiseId;
    private String name;
    private Set<Branch> branches;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}

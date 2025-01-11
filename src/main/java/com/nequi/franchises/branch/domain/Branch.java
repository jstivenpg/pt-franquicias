package com.nequi.franchises.branch.domain;

import com.nequi.franchises.franchise.domain.Franchise;
import com.nequi.franchises.product.infrastructure.web.dtos.ProductDTO;
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
public class Branch implements Serializable {
    private Long branchId;
    private String name;
    private Franchise franchise;
    Set<ProductDTO> products;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}

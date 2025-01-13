package com.nequi.franchises.product.domain;

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
public class Product implements Serializable {
    private Long productId;
    private String name;
    private Long stock;
    private Long branchId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}

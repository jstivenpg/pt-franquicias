package com.nequi.franchises.franchise.domain;

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
public class Franchise implements Serializable {
    private Long franchiseId;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}

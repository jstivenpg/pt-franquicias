package com.nequi.franchises.franchise.application.ports.out;


import com.nequi.franchises.franchise.domain.Franchise;

import java.util.List;

public interface FranchiseRepository {
    List<Franchise> findAll();
    Franchise getById(Long franchiseId);
    Franchise save (Franchise franchise);
    void delete(Long franchiseId);
}

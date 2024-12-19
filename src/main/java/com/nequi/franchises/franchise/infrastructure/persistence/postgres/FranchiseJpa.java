package com.nequi.franchises.franchise.infrastructure.persistence.postgres;

import com.nequi.franchises.franchise.infrastructure.persistence.postgres.FranchiseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseJpa extends JpaRepository<FranchiseModel, Long> {
}

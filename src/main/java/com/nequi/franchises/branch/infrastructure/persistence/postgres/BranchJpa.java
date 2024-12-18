package com.nequi.franchises.branch.infrastructure.persistence.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchJpa extends JpaRepository<BranchModel, Long> {
}

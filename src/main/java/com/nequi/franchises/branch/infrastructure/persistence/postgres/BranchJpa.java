package com.nequi.franchises.branch.infrastructure.persistence.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchJpa extends JpaRepository<BranchModel, Long> {

    List<BranchModel> findByFranchise_FranchiseId(Long franchiseId);
}

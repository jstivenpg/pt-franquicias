package com.nequi.franchises.branch.application.ports.out;

import com.nequi.franchises.branch.domain.Branch;

import java.util.List;

public interface BranchRepository {
    List<Branch> findAll();
    Branch getById(Long branchId);
    List<Branch> getByFranchiseId(Long franchiseId);
    Branch save (Branch branch);
    void delete(Long branchId);
}

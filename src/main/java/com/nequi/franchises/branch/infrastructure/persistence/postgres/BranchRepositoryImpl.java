package com.nequi.franchises.branch.infrastructure.persistence.postgres;

import com.nequi.franchises.branch.application.mappers.BranchMapper;
import com.nequi.franchises.branch.application.ports.out.BranchRepository;
import com.nequi.franchises.branch.domain.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BranchRepositoryImpl implements BranchRepository {

    private final BranchJpa branchJpa;
    private final BranchMapper branchMapper;

    @Override
    public List<Branch> findAll() {
        return branchJpa.findAll().stream().map(branchMapper::branchModelToBranch).toList();
    }

    @Override
    public Branch getById(Long branchId) {
        BranchModel branchModel = branchJpa.findById(branchId).orElse(null);
        return branchMapper.branchModelToBranch(branchModel);
    }

    @Override
    public List<Branch> getByFranchiseId(Long franchiseId) {
        return branchJpa.findByFranchise_FranchiseId(franchiseId).stream().map(branchMapper::branchModelToBranch).toList();
    }

    @Override
    public Branch save(Branch branch) {
        BranchModel branchModel = branchMapper.branchToBranchModel(branch);
        branchJpa.save(branchModel);

        return branchMapper.branchModelToBranch(branchModel);
    }

    @Override
    public void delete(Long branchId) {
        branchJpa.deleteById(branchId);
    }
}

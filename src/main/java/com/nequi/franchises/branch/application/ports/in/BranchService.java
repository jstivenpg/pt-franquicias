package com.nequi.franchises.branch.application.ports.in;

import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;

import java.util.List;

public interface BranchService {
    GeneralResponse<List<BranchDTO>> getAllBranchs();
    GeneralResponse<BranchDTO> getBranchById(Long branchId);
    GeneralResponse<BranchDTO> createBranch(BranchDTO branch);
    GeneralResponse<BranchDTO> updateBranch(Long branchId, BranchDTO branch);
    void deleteBranch(Long branchId);
}

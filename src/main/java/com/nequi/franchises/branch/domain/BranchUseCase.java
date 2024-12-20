package com.nequi.franchises.branch.domain;

import com.nequi.franchises.branch.application.mappers.BranchMapper;
import com.nequi.franchises.branch.application.ports.in.BranchService;
import com.nequi.franchises.branch.application.ports.out.BranchRepository;
import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;
import com.nequi.franchises.shared.application.dtos.ResponseCode;
import com.nequi.franchises.shared.application.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchUseCase implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    @Override
    public GeneralResponse<List<BranchDTO>> getAllBranchs() {
        List<BranchDTO> branchsDto = branchRepository.findAll().stream().map(branchMapper::branchToDto).toList();

        return new GeneralResponse<>(branchsDto);
    }

    @Override
    public GeneralResponse<BranchDTO> getBranchById(Long branchId) {
        Branch branchEntity = branchRepository.getById(branchId);
        if (branchEntity == null) {
            throw new ApiException(ResponseCode.BRANCH_NOT_FOUND, branchId);
        }

        BranchDTO branchDto = branchMapper.branchToDto(branchEntity);
        return new GeneralResponse<>(branchDto);
    }

    @Override
    public GeneralResponse<BranchDTO> createBranch(BranchDTO branch) {
        Branch branchEntity = branchMapper.dtoToBranch(branch);

        return new GeneralResponse<>(saveBranch(branchEntity));
    }

    @Override
    public GeneralResponse<BranchDTO> updateBranch(Long branchId, BranchDTO branch) {
        Branch branchEntity = branchRepository.getById(branchId);

        branchEntity.setBranchId(branchId);
        Optional.ofNullable(branch.name()).ifPresent(branchEntity::setName);

        return new GeneralResponse<>(saveBranch(branchEntity));
    }

    @Override
    public void deleteBranch(Long branchId) {
        try {
            branchRepository.delete(branchId);
        } catch (Exception e) {
            log.error("Error deleting branch with id: {}", branchId, e);
            throw new ApiException(ResponseCode.BRANCH_NOT_DELETED, branchId);
        }
    }

    private BranchDTO saveBranch(Branch branch) {
        try {
            return branchMapper.branchToDto(branchRepository.save(branch));
        } catch (Exception e) {
            log.error("Error saving branch: {}", branch, e);
            throw new ApiException(ResponseCode.UNEXPECTED_ERROR, e);
        }
    }
}

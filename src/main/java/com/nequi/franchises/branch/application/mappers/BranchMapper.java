package com.nequi.franchises.branch.application.mappers;

import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;
import com.nequi.franchises.branch.domain.Branch;
import com.nequi.franchises.branch.infrastructure.persistence.postgres.BranchModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BranchMapper {

    // BranchEntity domain -> BranchDTO application and reverse
    Branch dtoToBranch(BranchDTO branchDto);
    List<Branch> dtoListToBranch(List<BranchDTO> branchDto);
    BranchDTO branchToDto(Branch branch);
    List<BranchDTO> branchListToDto(List<Branch> branch);

    // BranchEntity domain -> BranchModel adapter and reverse
    Branch branchModelToBranch(BranchModel branchModel);
    List<Branch> branchModelListToBranch(List<BranchModel> branchModel);
    BranchModel branchToBranchModel(Branch branch);
    List<BranchModel> branchListToBranchModel(List<Branch> branch);
}

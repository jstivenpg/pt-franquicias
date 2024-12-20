package com.nequi.franchises.branch.application.mappers;

import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;
import com.nequi.franchises.branch.domain.Branch;
import com.nequi.franchises.branch.infrastructure.persistence.postgres.BranchModel;
import com.nequi.franchises.franchise.domain.Franchise;
import com.nequi.franchises.franchise.infrastructure.persistence.postgres.FranchiseModel;
import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BranchMapper {
    // BranchEntity domain -> BranchDTO application and reverse
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "toFranchise")
    Branch dtoToBranch(BranchDTO branchDto);
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "toFranchiseDTO")
    BranchDTO branchToDto(Branch branch);

    // BranchEntity domain -> BranchModel adapter and reverse
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "toFranchise")
    Branch branchModelToBranch(BranchModel branchModel);
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "toFranchiseModel")
    BranchModel branchToBranchModel(Branch branch);

    // Use this for mapping
    @Named("toFranchise")
    @Mapping(target = "branches", source = "branches", ignore = true)
    Franchise toFranchise(FranchiseDTO franchiseDTO);

    @Named("toFranchiseDTO")
    @Mapping(target = "branches", source = "branches", ignore = true)
    FranchiseDTO toFranchiseDTO(Franchise franchise);

    @Named("toFranchise")
    @Mapping(target = "branches", source = "branches", ignore = true)
    Franchise toFranchise(FranchiseModel franchiseModel);

    @Named("toFranchiseModel")
    @Mapping(target = "branches", source = "branches", ignore = true)
    FranchiseModel toFranchiseModel(Franchise franchise);
}

package com.nequi.franchises.franchise.application.mappers;

import com.nequi.franchises.branch.domain.Branch;
import com.nequi.franchises.branch.infrastructure.persistence.postgres.BranchModel;
import com.nequi.franchises.branch.infrastructure.web.dtos.BranchDTO;
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
public interface FranchiseMapper {

    // FranchiseEntity domain -> FranchiseDTO application and reverse
    @Mapping(target = "branches", source = "branches", qualifiedByName = "toBranch")
    Franchise dtoToFranchise(FranchiseDTO franchiseDTO);
    @Mapping(target = "branches", source = "branches", qualifiedByName = "toBranchDTO")
    FranchiseDTO franchiseToDto(Franchise franchise);

    // FranchiseEntity domain -> FranchiseModel adapter and reverse
    @Mapping(target = "branches", source = "branches", qualifiedByName = "toBranch")
    Franchise franchiseModelToFranchise(FranchiseModel franchiseModel);
    @Mapping(target = "branches", source = "branches", qualifiedByName = "toBranchModel")
    FranchiseModel franchiseToFranchiseModel(Franchise franchise);

    // Use this for mapping
    @Named("toBranch")
    @Mapping(target = "franchise", source = "franchise", ignore = true)
    Branch toBranch(BranchDTO branchDTO);

    @Named("toBranchDTO")
    @Mapping(target = "franchise", source = "franchise", ignore = true)
    BranchDTO toBranchDTO(Branch branch);

    @Named("toBranch")
    @Mapping(target = "franchise", source = "franchise", ignore = true)
    Branch toBranch(BranchModel branchModel);

    @Named("toBranchModel")
    @Mapping(target = "franchise", source = "franchise", ignore = true)
    BranchModel toBranch(Branch branch);


}

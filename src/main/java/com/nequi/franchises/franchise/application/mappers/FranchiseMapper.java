package com.nequi.franchises.franchise.application.mappers;

import com.nequi.franchises.franchise.domain.Franchise;
import com.nequi.franchises.franchise.infrastructure.persistence.postgres.FranchiseModel;
import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FranchiseMapper {

    // FranchiseEntity domain -> FranchiseDTO application and reverse
    Franchise dtoToFranchise(FranchiseDTO franchiseDTO);
    List<Franchise> dtoListToFranchise(List<FranchiseDTO> franchiseDTO);
    FranchiseDTO franchiseToDto(Franchise franchise);
    List<FranchiseDTO> franchiseListToDto(List<Franchise> franchise);

    // FranchiseEntity domain -> FranchiseModel adapter and reverse
    Franchise franchiseModelToFranchise(FranchiseModel franchiseModel);
    List<Franchise> franchiseModelListToFranchise(List<FranchiseModel> franchiseModel);
    FranchiseModel franchiseToFranchiseModel(Franchise franchise);
    List<FranchiseModel> franchiseListToFranchiseModel(List<Franchise> franchise);
}

package com.nequi.franchises.franchise.application.ports.in;

import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;
import com.nequi.franchises.shared.application.dtos.GeneralResponse;

import java.util.List;

public interface FranchiseService {
    GeneralResponse<List<FranchiseDTO>> getAllFranchises();
    GeneralResponse<FranchiseDTO> getFranchiseById(Long franchiseId);
    GeneralResponse<FranchiseDTO> createFranchise(FranchiseDTO franchise);
    GeneralResponse<FranchiseDTO> updateFranchise(Long franchiseId, FranchiseDTO franchise);
    void deleteFranchise(Long franchiseId);
}

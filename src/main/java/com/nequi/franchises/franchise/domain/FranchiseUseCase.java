package com.nequi.franchises.franchise.domain;

import com.nequi.franchises.franchise.application.mappers.FranchiseMapper;
import com.nequi.franchises.franchise.application.ports.in.FranchiseService;
import com.nequi.franchises.franchise.application.ports.out.FranchiseRepository;
import com.nequi.franchises.franchise.infrastructure.web.dtos.FranchiseDTO;
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
public class FranchiseUseCase implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseMapper franchiseMapper;

    @Override
    public GeneralResponse<List<FranchiseDTO>> getAllFranchises() {
        List<FranchiseDTO> franchisesDto = franchiseRepository.findAll().stream().map(
                franchiseMapper::franchiseToDto
        ).toList();

        return new GeneralResponse<>(franchisesDto);
    }

    @Override
    public GeneralResponse<FranchiseDTO> getFranchiseById(Long franchiseId) {
        Franchise franchiseEntity = franchiseRepository.getById(franchiseId);
        if (franchiseEntity == null) {
            throw new ApiException(ResponseCode.FRANCHISE_NOT_FOUND, franchiseId);
        }

        FranchiseDTO franchiseDto = franchiseMapper.franchiseToDto(franchiseEntity);
        return new GeneralResponse<>(franchiseDto);
    }

    @Override
    public GeneralResponse<FranchiseDTO> createFranchise(FranchiseDTO franchise) {
        Franchise franchiseEntity = franchiseMapper.dtoToFranchise(franchise);

        return new GeneralResponse<>(saveFranchise(franchiseEntity));
    }

    @Override
    public GeneralResponse<FranchiseDTO> updateFranchise(Long franchiseId, FranchiseDTO franchise) {
        Franchise franchiseEntity = franchiseRepository.getById(franchiseId);

        franchiseEntity.setFranchiseId(franchiseId);
        Optional.ofNullable(franchise.name()).ifPresent(franchiseEntity::setName);

        return new GeneralResponse<>(saveFranchise(franchiseEntity));
    }

    @Override
    public void deleteFranchise(Long franchiseId) {
        try {
            franchiseRepository.delete(franchiseId);
        } catch (Exception e) {
            log.error("Error deleting franchise with id: {}", franchiseId, e);
            throw new ApiException(ResponseCode.FRANCHISE_NOT_DELETED, franchiseId);
        }
    }

    private FranchiseDTO saveFranchise(Franchise franchise) {
        try {
            return franchiseMapper.franchiseToDto(franchiseRepository.save(franchise));
        } catch (Exception e) {
            log.error("Error saving franchise: {}", franchise, e);
            throw new ApiException(ResponseCode.UNEXPECTED_ERROR, e);
        }
    }
}

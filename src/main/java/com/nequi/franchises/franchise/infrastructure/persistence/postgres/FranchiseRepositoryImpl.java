package com.nequi.franchises.franchise.infrastructure.persistence.postgres;

import com.nequi.franchises.franchise.application.mappers.FranchiseMapper;
import com.nequi.franchises.franchise.application.ports.out.FranchiseRepository;
import com.nequi.franchises.franchise.domain.Franchise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FranchiseRepositoryImpl implements FranchiseRepository {

    private final FranchiseJpa franchiseJpa;
    private final FranchiseMapper franchiseMapper;

    @Override
    public List<Franchise> findAll() {
        return franchiseJpa.findAll().stream().map(franchiseMapper::franchiseModelToFranchise).toList();
    }

    @Override
    public Franchise getById(Long franchiseId) {
        FranchiseModel franchiseModel = franchiseJpa.findById(franchiseId).orElse(null);

        return franchiseMapper.franchiseModelToFranchise(franchiseModel);
    }

    @Override
    public Franchise save(Franchise franchise) {
        FranchiseModel franchiseModel = franchiseMapper.franchiseToFranchiseModel(franchise);
        franchiseJpa.save(franchiseModel);

        return franchiseMapper.franchiseModelToFranchise(franchiseModel);
    }

    @Override
    public void delete(Long franchiseId) {
        franchiseJpa.deleteById(franchiseId);
    }
}

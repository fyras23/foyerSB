package com.esprit.foyer.services;

import com.esprit.foyer.Repo.UniversiteRepo;
import com.esprit.foyer.dto.UniversiteDTO;
import com.esprit.foyer.entities.Universite;
import com.esprit.foyer.mappers.UniversiteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    private final UniversiteRepo universiteRepository;
    private final UniversiteMapper universiteMapper;

    @Override
    public UniversiteDTO addOrUpdateUniversite(UniversiteDTO universiteDTO) {
        Universite universite = universiteMapper.toEntity(universiteDTO);
        Universite saved = universiteRepository.save(universite);
        return universiteMapper.toDto(saved);
    }

    @Override
    public UniversiteDTO findUniversiteById(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow();
        return universiteMapper.toDto(universite);
    }

    @Override
    public List<UniversiteDTO> findAllUniversites() {
        return universiteRepository.findAll()
                .stream()
                .map(universiteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUniversiteById(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}

package com.esprit.foyer.services;

import com.esprit.foyer.Repo.FoyerRepo;
import com.esprit.foyer.dto.FoyerDTO;
import com.esprit.foyer.entities.Foyer;
import com.esprit.foyer.mappers.FoyerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {

    private final FoyerRepo foyerRepository;
    private final FoyerMapper foyerMapper;

    @Override
    public FoyerDTO addOrUpdateFoyer(FoyerDTO foyerDTO) {
        Foyer foyer = foyerMapper.toEntity(foyerDTO);
        Foyer saved = foyerRepository.save(foyer);
        return foyerMapper.toDto(saved);
    }

    @Override
    public FoyerDTO findFoyerById(Long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow();
        return foyerMapper.toDto(foyer);
    }

    @Override
    public List<FoyerDTO> findAllFoyers() {
        return foyerRepository.findAll()
                .stream()
                .map(foyerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFoyerById(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}

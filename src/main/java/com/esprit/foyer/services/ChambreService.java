package com.esprit.foyer.services;

import com.esprit.foyer.Repo.ChambreRepo;
import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.entities.Chambre;
import com.esprit.foyer.mappers.ChambreMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {

    private final ChambreRepo chambreRepo;
    private final ChambreMapper chambreMapper;

    @Override
    public ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO) {
        Chambre chambre = chambreMapper.toEntity(chambreDTO);
        Chambre saved = chambreRepo.save(chambre);
        return chambreMapper.toDto(saved);
    }

    @Override
    public ChambreDTO findChambreById(Long idChambre) {
        Chambre chambre = chambreRepo.findById(idChambre).orElseThrow();
        return chambreMapper.toDto(chambre);
    }

    @Override
    public List<ChambreDTO> findAllChambres() {
        return chambreRepo.findAll()
                .stream()
                .map(chambreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChambreById(Long idChambre) {
        chambreRepo.deleteById(idChambre);
    }
}

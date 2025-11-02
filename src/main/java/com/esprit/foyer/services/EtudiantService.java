package com.esprit.foyer.services;

import com.esprit.foyer.Repo.EtudiantRepo;
import com.esprit.foyer.dto.EtudiantDTO;
import com.esprit.foyer.entities.Etudiant;
import com.esprit.foyer.mappers.EtudiantMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {

    private final EtudiantRepo etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    @Override
    public EtudiantDTO addOrUpdateEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        Etudiant saved = etudiantRepository.save(etudiant);
        return etudiantMapper.toDto(saved);
    }

    @Override
    public EtudiantDTO findEtudiantById(Long idEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElseThrow();
        return etudiantMapper.toDto(etudiant);
    }

    @Override
    public List<EtudiantDTO> findAllEtudiants() {
        return etudiantRepository.findAll()
                .stream()
                .map(etudiantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEtudiantById(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}

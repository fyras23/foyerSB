package com.esprit.foyer.services;

import com.esprit.foyer.dto.EtudiantDTO;
import java.util.List;

public interface IEtudiantService {
    EtudiantDTO addOrUpdateEtudiant(EtudiantDTO etudiantDTO);
    EtudiantDTO findEtudiantById(Long idEtudiant);
    List<EtudiantDTO> findAllEtudiants();
    void deleteEtudiantById(Long idEtudiant);
}

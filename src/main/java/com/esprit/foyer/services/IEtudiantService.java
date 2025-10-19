package com.esprit.foyer.services;

import com.esprit.foyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    Etudiant findEtudiantById(Long idEtudiant);
    List<Etudiant> findAllEtudiants();
    void deleteEtudiantById(Long idEtudiant);
}

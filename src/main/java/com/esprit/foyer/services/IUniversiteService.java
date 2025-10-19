package com.esprit.foyer.services;

import com.esprit.foyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addOrUpdateUniversite(Universite universite);
    Universite findUniversiteById(Long idUniversite);
    List<Universite> findAllUniversites();
    void deleteUniversiteById(Long idUniversite);
}

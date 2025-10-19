package com.esprit.foyer.services;

import com.esprit.foyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdateFoyer(Foyer foyer);
    Foyer findFoyerById(Long idFoyer);
    List<Foyer> findAllFoyers();
    void deleteFoyerById(Long idFoyer);
}

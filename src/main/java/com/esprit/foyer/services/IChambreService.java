package com.esprit.foyer.services;

import com.esprit.foyer.entities.Chambre;

import java.util.List;

public interface IChambreService {
    public Chambre addOrUpdateChambre(Chambre chambre);
    public Chambre findChambreById(Long idChambre);
    public List<Chambre> findAllChambres();
    public void deleteChambreById(Long idChambre);
}

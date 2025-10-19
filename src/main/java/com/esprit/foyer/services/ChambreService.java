package com.esprit.foyer.services;

import com.esprit.foyer.Repo.ChambreRepo;
import com.esprit.foyer.entities.Chambre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreService implements  IChambreService {
    final ChambreRepo chambreRepo;

    @Override
    public Chambre addOrUpdateChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre findChambreById(Long idChambre) {
        return chambreRepo.findById(idChambre).get();
    }

    @Override
    public List<Chambre> findAllChambres() {
        /* i need to get to back to this if there is an error after */
        return chambreRepo.findAll();
    }

    @Override
    public void deleteChambreById(Long idChambre) {
        chambreRepo.deleteById(idChambre);

    }
}

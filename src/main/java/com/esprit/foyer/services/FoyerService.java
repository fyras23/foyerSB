package com.esprit.foyer.services;

import com.esprit.foyer.Repo.FoyerRepo;
import com.esprit.foyer.entities.Foyer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    final FoyerRepo foyerRepository;

    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer findFoyerById(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public void deleteFoyerById(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}

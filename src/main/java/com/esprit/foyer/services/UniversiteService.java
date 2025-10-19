package com.esprit.foyer.services;


import com.esprit.foyer.Repo.UniversiteRepo;
import com.esprit.foyer.entities.Universite;
import com.esprit.foyer.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {
    final UniversiteRepo universiteRepository;

    @Override
    public Universite addOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite findUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> findAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversiteById(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}

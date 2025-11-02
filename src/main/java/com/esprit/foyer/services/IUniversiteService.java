package com.esprit.foyer.services;

import com.esprit.foyer.dto.UniversiteDTO;
import java.util.List;

public interface IUniversiteService {
    UniversiteDTO addOrUpdateUniversite(UniversiteDTO universiteDTO);
    UniversiteDTO findUniversiteById(Long idUniversite);
    List<UniversiteDTO> findAllUniversites();
    void deleteUniversiteById(Long idUniversite);
}

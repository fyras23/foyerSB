package com.esprit.foyer.services;

import com.esprit.foyer.dto.FoyerDTO;
import java.util.List;

public interface IFoyerService {
    FoyerDTO addOrUpdateFoyer(FoyerDTO foyerDTO);
    FoyerDTO findFoyerById(Long idFoyer);
    List<FoyerDTO> findAllFoyers();
    void deleteFoyerById(Long idFoyer);
}

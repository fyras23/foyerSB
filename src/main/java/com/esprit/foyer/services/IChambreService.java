package com.esprit.foyer.services;

import com.esprit.foyer.dto.ChambreDTO;
import java.util.List;

public interface IChambreService {
    ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO);
    ChambreDTO findChambreById(Long idChambre);
    List<ChambreDTO> findAllChambres();
    void deleteChambreById(Long idChambre);
}

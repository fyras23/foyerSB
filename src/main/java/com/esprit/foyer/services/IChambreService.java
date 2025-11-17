package com.esprit.foyer.services;

import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.dto.ChambreReservationDTO;

import java.util.List;

public interface IChambreService {
    ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO);
    ChambreDTO findChambreById(Long idChambre);
    List<ChambreDTO> findAllChambres();
    void deleteChambreById(Long idChambre);

    ChambreReservationDTO addChambreWithReservation(ChambreReservationDTO dto);
    ChambreReservationDTO assignReservation(Long chambreId, String reservationId);
    ChambreReservationDTO cancelReservation(Long chambreId);


}

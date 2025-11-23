package com.esprit.foyer.services;

import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.dto.ChambreReservationDTO;
import com.esprit.foyer.entities.Chambre;
import com.esprit.foyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    ChambreDTO addOrUpdateChambre(ChambreDTO chambreDTO);
    ChambreDTO findChambreById(Long idChambre);
    List<ChambreDTO> findAllChambres();
    void deleteChambreById(Long idChambre);

    ChambreReservationDTO addChambreWithReservation(ChambreReservationDTO dto);
    ChambreReservationDTO assignReservation(Long chambreId, String reservationId);
    ChambreReservationDTO cancelReservation(Long chambreId, String reservationId);



    List<Chambre> findByType(TypeChambre type);
    ChambreDTO findByNumero(Long numeroChambre);


}

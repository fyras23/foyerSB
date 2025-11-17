package com.esprit.foyer.dto;

import com.esprit.foyer.entities.Reservation;
import lombok.Data;
import java.util.Set;

@Data
public class ChambreReservationDTO {
    private Long idChambre;
    private Long numeroChambre;
    private String typeC;
    private Set<ReservationDTO> reservations;
}

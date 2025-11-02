package com.esprit.foyer.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ReservationDTO {
    private String idReservation;
    private Boolean estValide;
    private Date anneeUniversitaire;
}

package com.esprit.foyer.dto;

import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class ReservationDTO {
    private String idReservation;
    private Boolean estValide;
    private Date anneeUniversitaire;

    private Set<Long> etudiantIds; 
}

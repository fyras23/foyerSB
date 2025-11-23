package com.esprit.foyer.dto;

import com.esprit.foyer.entities.TypeChambre;
import lombok.Data;

import java.util.Set;

@Data
public class ChambreDTO {
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre typeC;
    private Long blocId;
    private Set<String> reservationIds;
}

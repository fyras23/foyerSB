package com.esprit.foyer.dto;

import lombok.Data;

@Data
public class UniversiteDTO {
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    private Long foyerId; // simplified relation
}

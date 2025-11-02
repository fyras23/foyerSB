package com.esprit.foyer.dto;

import lombok.Data;
import java.util.Date;

@Data
public class EtudiantDTO {
    private Long idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private Long cin;
    private String ecole;
    private Date dateNaissance;
}

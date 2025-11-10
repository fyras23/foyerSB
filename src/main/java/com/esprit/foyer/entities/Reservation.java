package com.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity

public class Reservation {
    @Id

    private String idReservation;
    private Boolean estValide;

    private Date anneeUniversitaire;
    @ManyToMany
    Set<Etudiant> etudiants;

}

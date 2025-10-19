package com.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;

    private String adresse;
    @OneToOne
    Foyer foyers;
}

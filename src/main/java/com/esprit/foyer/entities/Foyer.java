package com.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;

    private Long capaciteFoyer;
    @OneToOne(mappedBy = "foyers")
    Universite universites;

    @OneToMany(mappedBy = "foyer")
    Set<Bloc> blocs;

}

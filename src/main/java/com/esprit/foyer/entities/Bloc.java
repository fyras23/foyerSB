package com.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;

    private Long capaciteBloc;
    @ManyToOne
    Foyer foyer;

    @OneToMany(mappedBy = "blocs")
    Set<Chambre> chambres;


}

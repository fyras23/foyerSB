package com.esprit.foyer.dto;

import lombok.Data;
import java.util.Set;

@Data
public class BlocFoyerDTO {
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
    private FoyerDTO foyer;  // For creating foyer at the same time
    private Set<Long> chambreIds;

    // Remove foyerId since we're creating the foyer, not referencing an existing one
}
package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.EtudiantDTO;
import com.esprit.foyer.entities.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    @Mapping(
            target = "reservationIds",
            expression = "java( etudiant.getResrv() == null ? null : etudiant.getResrv().stream()"
                    + ".map(res -> res.getIdReservation())"
                    + ".collect(java.util.stream.Collectors.toSet()) )"
    )
    EtudiantDTO toDto(Etudiant etudiant);

    @Mapping(target = "resrv", ignore = true)
    Etudiant toEntity(EtudiantDTO dto);
}

package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.ReservationDTO;
import com.esprit.foyer.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(
            target = "etudiantIds",
            expression = "java( reservation.getEtudiants() == null ? null : reservation.getEtudiants().stream()"
                    + ".map(et -> et.getIdEtudiant())"
                    + ".collect(java.util.stream.Collectors.toSet()) )"
    )
    ReservationDTO toDto(Reservation reservation);

    @Mapping(target = "etudiants", ignore = true)
    Reservation toEntity(ReservationDTO dto);
}

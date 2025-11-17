package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.ChambreReservationDTO;
import com.esprit.foyer.dto.ReservationDTO;
import com.esprit.foyer.entities.Chambre;
import com.esprit.foyer.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ChambreReservationMapper {


    @Mapping(source = "reservation", target = "reservations", qualifiedByName = "reservationToDTOs")
    ChambreReservationDTO toDto(Chambre chambre);


    @Mapping(target = "reservation", ignore = true) // reservations handled manually
    Chambre toEntity(ChambreReservationDTO dto);

    @Named("reservationToDTOs")
    default Set<ReservationDTO> reservationToDTOs(Set<Reservation> reservations) {
        if (reservations == null) return null;
        return reservations.stream()
                .map(r -> {
                    ReservationDTO dto = new ReservationDTO();
                    dto.setIdReservation(r.getIdReservation());
                    dto.setAnneeUniversitaire(r.getAnneeUniversitaire());
                    dto.setEstValide(r.getEstValide());

                    return dto;
                }).collect(Collectors.toSet());
    }
}

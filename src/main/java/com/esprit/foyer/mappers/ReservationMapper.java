package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.ReservationDTO;
import com.esprit.foyer.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationDTO toDto(Reservation reservation);

    Reservation toEntity(ReservationDTO dto);
}

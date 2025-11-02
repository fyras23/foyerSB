package com.esprit.foyer.services;

import com.esprit.foyer.dto.ReservationDTO;
import java.util.List;

public interface IReservationService {
    ReservationDTO addOrUpdateReservation(ReservationDTO reservationDTO);
    ReservationDTO findReservationById(String idReservation);
    List<ReservationDTO> findAllReservations();
    void deleteReservationById(String idReservation);
}

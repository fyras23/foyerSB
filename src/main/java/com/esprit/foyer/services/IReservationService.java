package com.esprit.foyer.services;

import com.esprit.foyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addOrUpdateReservation(Reservation reservation);
    Reservation findReservationById(String idReservation);
    List<Reservation> findAllReservations();
    void deleteReservationById(String idReservation);
}

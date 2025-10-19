package com.esprit.foyer.services;

import com.esprit.foyer.Repo.ReservationRepo;
import com.esprit.foyer.entities.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    final ReservationRepo reservationRepository;

    @Override
    public Reservation addOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findReservationById(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservationById(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}

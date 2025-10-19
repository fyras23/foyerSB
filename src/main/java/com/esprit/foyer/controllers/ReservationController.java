package com.esprit.foyer.controllers;

import com.esprit.foyer.entities.Reservation;
import com.esprit.foyer.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    final ReservationService reservationService;

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addOrUpdateReservation(reservation);
    }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.addOrUpdateReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> findAllReservations() {
        return reservationService.findAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation findReservationById(@PathVariable String id) {
        return reservationService.findReservationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservationById(id);
    }
}

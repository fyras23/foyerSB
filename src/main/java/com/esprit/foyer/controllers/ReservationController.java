package com.esprit.foyer.controllers;

import com.esprit.foyer.dto.ReservationDTO;
import com.esprit.foyer.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/add")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.addOrUpdateReservation(reservationDTO);
    }

    @PutMapping("/update")
    public ReservationDTO updateReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.addOrUpdateReservation(reservationDTO);
    }

    @GetMapping("/all")
    public List<ReservationDTO> findAllReservations() {
        return reservationService.findAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationDTO findReservationById(@PathVariable String id) {
        return reservationService.findReservationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservationById(id);
    }
}

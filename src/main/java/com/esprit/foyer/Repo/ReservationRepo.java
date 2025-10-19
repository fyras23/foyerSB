package com.esprit.foyer.Repo;

import com.esprit.foyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReservationRepo extends JpaRepository<Reservation, String> {
}

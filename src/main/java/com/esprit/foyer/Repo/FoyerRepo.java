package com.esprit.foyer.Repo;

import com.esprit.foyer.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FoyerRepo extends JpaRepository<Foyer, Long> {
}

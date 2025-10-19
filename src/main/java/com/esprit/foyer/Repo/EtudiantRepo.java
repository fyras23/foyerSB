package com.esprit.foyer.Repo;

import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
}

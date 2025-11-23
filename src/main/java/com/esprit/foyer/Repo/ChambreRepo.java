package com.esprit.foyer.Repo;

import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.entities.Chambre;
import com.esprit.foyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
    List<Chambre> findByTypeC(TypeChambre typeC);

    Chambre findByNumeroChambre(Long numeroChambre);
}

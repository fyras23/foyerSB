package com.esprit.foyer.Repo;

import com.esprit.foyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> {
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);
    List<Bloc> findByNomBlocStartingWith(String prefix);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String prefix, Long capacite);
}

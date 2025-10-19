package com.esprit.foyer.services;

import com.esprit.foyer.Repo.BlocRepo;
import com.esprit.foyer.entities.Bloc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {
    final BlocRepo blocRepository;
    @Override
    public Bloc addOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc findBlocById(long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public List<Bloc> findAllBlocs() {
        return List.of();
    }

    @Override
    public void deleteBlocById(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}

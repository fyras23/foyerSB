package com.esprit.foyer.services;

import com.esprit.foyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    public Bloc addOrUpdateBloc(Bloc bloc);
    public Bloc findBlocById(long idBloc);
    public List<Bloc> findAllBlocs();
    public void deleteBlocById(long idBloc);
}

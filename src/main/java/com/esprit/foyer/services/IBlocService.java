package com.esprit.foyer.services;

import com.esprit.foyer.dto.BlocDTO;
import com.esprit.foyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    BlocDTO addOrUpdateBloc(BlocDTO blocDTO);
    BlocDTO findBlocById(long idBloc);
    List<BlocDTO> findAllBlocs();
    void deleteBlocById(long idBloc);
}

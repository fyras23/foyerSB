package com.esprit.foyer.services;

import com.esprit.foyer.dto.BlocDTO;
import com.esprit.foyer.dto.BlocFoyerDTO;
import com.esprit.foyer.dto.FoyerDTO;
import com.esprit.foyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    BlocDTO addOrUpdateBloc(BlocDTO blocDTO);
    BlocDTO findBlocById(long idBloc);
    List<BlocDTO> findAllBlocs();
    void deleteBlocById(long idBloc);


    public BlocFoyerDTO addBlocWithNewFoyer(BlocFoyerDTO BFdto);
    BlocDTO assignBlocToFoyer(Long idBloc, Long idFoyer);
    BlocDTO decommissionBlocFoyer(Long idBloc);
}

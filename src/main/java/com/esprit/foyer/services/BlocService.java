package com.esprit.foyer.services;

import com.esprit.foyer.Repo.BlocRepo;
import com.esprit.foyer.Repo.FoyerRepo;
import com.esprit.foyer.dto.BlocDTO;
import com.esprit.foyer.dto.BlocFoyerDTO;
import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.entities.Foyer;
import com.esprit.foyer.mappers.BlocFoyerMapper;
import com.esprit.foyer.mappers.BlocMapper;
import com.esprit.foyer.mappers.FoyerMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {
    final BlocRepo blocRepository;
    private final BlocMapper blocMapper;
    final BlocFoyerMapper blocFoyerMapper;
    final FoyerMapper foyerMapper;
    final FoyerRepo foyerRepo;
    @Override
    public BlocDTO addOrUpdateBloc(BlocDTO blocDTO) {
        Bloc bloc = blocMapper.toEntity(blocDTO);
        Bloc saved = blocRepository.save(bloc);
        return blocMapper.toDto(saved);
    }

    @Override
    public BlocDTO findBlocById(long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow();
        return blocMapper.toDto(bloc);
    }

    @Override
    public List<BlocDTO> findAllBlocs() {
        return blocRepository.findAll()
                .stream()
                .map(blocMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBlocById(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public BlocFoyerDTO addBlocWithNewFoyer(BlocFoyerDTO BFdto) {
        if (BFdto.getFoyer() == null) {
            throw new IllegalArgumentException("Foyer information is required");
        }

        // Convert DTO to Entity
        Bloc bloc = blocFoyerMapper.toEntity(BFdto);

        // Create and save the new Foyer first
        Foyer foyer = foyerMapper.toEntity(BFdto.getFoyer());
        foyer = foyerRepo.save(foyer);

        // Link the Foyer to the Bloc
        bloc.setFoyer(foyer);

        // Save the Bloc
        bloc = blocRepository.save(bloc);

        // Return the result
        return blocFoyerMapper.toDto(bloc);
    }

    @Override
    @Transactional
    public BlocDTO assignBlocToFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow();
        Foyer foyer = foyerRepo.findById(idFoyer).orElseThrow();

        bloc.setFoyer(foyer);
        blocRepository.save(bloc);

        return blocMapper.toDto(bloc);
    }

    @Override
    @Transactional
    public BlocDTO decommissionBlocFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow();
        bloc.setFoyer(null);

        blocRepository.save(bloc);
        return blocMapper.toDto(bloc);
    }


}

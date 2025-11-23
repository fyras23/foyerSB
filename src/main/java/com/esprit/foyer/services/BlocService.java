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

import java.util.ArrayList;
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


        Bloc bloc = blocFoyerMapper.toEntity(BFdto);


        Foyer foyer = foyerMapper.toEntity(BFdto.getFoyer());
        foyer = foyerRepo.save(foyer);


        bloc.setFoyer(foyer);


        bloc = blocRepository.save(bloc);


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


    @Override
    public List<BlocDTO> findBlocsNonAffectes() {
        List<Bloc> blocs = blocRepository.findByFoyerIsNull();
        List<BlocDTO> blocDTOs = new ArrayList<>();
        for (Bloc bloc : blocs) {
            blocDTOs.add(blocMapper.toDto(bloc));
        }
        return blocDTOs;
    }

    @Override
    public List<BlocDTO> findBlocsByCapaciteSuperieurA(Long capacite) {
        List<Bloc> blocs = blocRepository.findByCapaciteBlocGreaterThan(capacite);
        List<BlocDTO> blocDTOs = new ArrayList<>();
        for (Bloc bloc : blocs) {
            blocDTOs.add(blocMapper.toDto(bloc));
        }
        return blocDTOs;
    }

    @Override
    public List<BlocDTO> findBlocsByNomCommencePar(String prefix) {
        List<Bloc> blocs = blocRepository.findByNomBlocStartingWith(prefix);
        List<BlocDTO> blocDTOs = new ArrayList<>();
        for (Bloc bloc : blocs) {
            blocDTOs.add(blocMapper.toDto(bloc));
        }
        return blocDTOs;
    }

    @Override
    public List<BlocDTO> findBlocsByNomEtCapacite(String prefix, Long capacite) {
        List<Bloc> blocs = blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(prefix, capacite);
        List<BlocDTO> blocDTOs = new ArrayList<>();
        for (Bloc bloc : blocs) {
            blocDTOs.add(blocMapper.toDto(bloc));
        }
        return blocDTOs;
    }
}

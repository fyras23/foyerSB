package com.esprit.foyer.services;

import com.esprit.foyer.Repo.BlocRepo;
import com.esprit.foyer.dto.BlocDTO;
import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.mappers.BlocMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {
    final BlocRepo blocRepository;
    private final BlocMapper blocMapper;
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
}

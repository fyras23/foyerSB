package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.EtudiantDTO;
import com.esprit.foyer.entities.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    EtudiantMapper INSTANCE = Mappers.getMapper(EtudiantMapper.class);


    EtudiantDTO toDto(Etudiant etudiant);


    Etudiant toEntity(EtudiantDTO dto);
}

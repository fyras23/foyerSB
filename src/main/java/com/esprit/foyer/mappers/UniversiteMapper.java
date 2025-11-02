package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.UniversiteDTO;
import com.esprit.foyer.entities.Universite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UniversiteMapper {

    UniversiteMapper INSTANCE = Mappers.getMapper(UniversiteMapper.class);


    @Mapping(source = "foyers.idFoyer", target = "foyerId")
    UniversiteDTO toDto(Universite universite);

    @Mapping(source = "foyerId", target = "foyers.idFoyer")
    Universite toEntity(UniversiteDTO dto);
}

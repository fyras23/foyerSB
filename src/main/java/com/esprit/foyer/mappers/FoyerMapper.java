package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.FoyerDTO;
import com.esprit.foyer.entities.Foyer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FoyerMapper {

    FoyerMapper INSTANCE = Mappers.getMapper(FoyerMapper.class);


    @Mapping(source = "universites.idUniversite", target = "universiteId")
    FoyerDTO toDto(Foyer foyer);


    @Mapping(source = "universiteId", target = "universites.idUniversite")
    @Mapping(target = "blocs", ignore = true)
    Foyer toEntity(FoyerDTO dto);
}

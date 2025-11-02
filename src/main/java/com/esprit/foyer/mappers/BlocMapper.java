package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.BlocDTO;
import com.esprit.foyer.entities.Bloc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BlocMapper {

    BlocMapper INSTANCE = Mappers.getMapper(BlocMapper.class);


    @Mapping(source = "foyer.idFoyer", target = "foyerId")
    BlocDTO toDto(Bloc bloc);


    @Mapping(source = "foyerId", target = "foyer.idFoyer")
    Bloc toEntity(BlocDTO dto);
}

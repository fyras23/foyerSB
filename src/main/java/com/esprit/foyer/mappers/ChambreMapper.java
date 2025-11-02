package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.entities.Chambre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChambreMapper {

    ChambreMapper INSTANCE = Mappers.getMapper(ChambreMapper.class);


    @Mapping(source = "blocs.idBloc", target = "blocId")
    @Mapping(source = "typeC", target = "typeC")
    ChambreDTO toDto(Chambre chambre);


    @Mapping(source = "blocId", target = "blocs.idBloc")
    @Mapping(target = "reservation", ignore = true) // ignore complex relation
    Chambre toEntity(ChambreDTO dto);
}

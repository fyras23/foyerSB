package com.esprit.foyer.mappers;

import com.esprit.foyer.dto.BlocFoyerDTO;
import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.entities.Chambre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {FoyerMapper.class})
public interface BlocFoyerMapper {

    @Mapping(source = "foyer", target = "foyer")
    @Mapping(source = "chambres", target = "chambreIds", qualifiedByName = "chambresToIds")
    BlocFoyerDTO toDto(Bloc bloc);

    @Mapping(source = "foyer", target = "foyer")
    @Mapping(target = "chambres", ignore = true)
    Bloc toEntity(BlocFoyerDTO dto);

    @Named("chambresToIds")
    default Set<Long> chambresToIds(Set<Chambre> chambres) {
        if (chambres == null) {
            return null;
        }
        return chambres.stream()
                .map(Chambre::getIdChambre)
                .collect(Collectors.toSet());
    }
}
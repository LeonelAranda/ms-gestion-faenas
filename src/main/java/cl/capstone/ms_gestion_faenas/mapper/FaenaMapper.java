package cl.capstone.ms_gestion_faenas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;
import cl.capstone.ms_gestion_faenas.model.Faena;
import cl.capstone.ms_gestion_faenas.model.TipoFaena;

@Mapper(componentModel = "spring")
public interface FaenaMapper {

    @Mapping(source = "tipoFaena.idTipoFaena", target = "idTipoFaena")
    @Mapping(source = "tipoFaena.nombreFaena", target = "nombreFaena") // Mapea el tipo de faena
    FaenaDTO toDto(Faena faena);

    @Mapping(source = "idTipoFaena", target = "tipoFaena")
    Faena toEntity(FaenaDTO faenaDTO);

    // Métodos de ayuda para el mapeo de tipoFaena
    default Long mapTipoFaenaToId(TipoFaena tipoFaena) {
        return tipoFaena != null ? tipoFaena.getIdTipoFaena() : null;
    }

    default TipoFaena mapIdToTipoFaena(Long idTipoFaena) {
        if (idTipoFaena == null) {
            return null;
        }
        TipoFaena tipoFaena = new TipoFaena();
        tipoFaena.setIdTipoFaena(idTipoFaena);
        return tipoFaena;
    }
}

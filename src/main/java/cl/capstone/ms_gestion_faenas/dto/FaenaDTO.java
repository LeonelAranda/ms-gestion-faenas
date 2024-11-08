package cl.capstone.ms_gestion_faenas.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FaenaDTO {

    private Long idFaena;

    private Long idTrabajador;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaTermino;

    private String encargado;

    private Long idTipoFaena;

    private String nombreFaena;
}

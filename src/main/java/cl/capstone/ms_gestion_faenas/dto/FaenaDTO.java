package cl.capstone.ms_gestion_faenas.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FaenaDTO {

    private Long idFaena;

    private Long idTrabajador;

    private LocalDate fechaInicio;

    private LocalDate fechaTermino;

    private String encargado;

    private Long idTipoFaena;

    private String nombreFaena;
}

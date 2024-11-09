package cl.capstone.ms_gestion_faenas.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CrearFaenaDTO {

    private Long idTrabajador;

    @DateTimeFormat(pattern = "dd-MM-yyyy") // Formato "dd-MM-yyyy"
    private LocalDate fechaInicio;

    @DateTimeFormat(pattern = "dd-MM-yyyy") // Formato "dd-MM-yyyy"
    private LocalDate fechaTermino;

    private String encargado;

    private Long idTipoFaena;

}

package cl.capstone.ms_gestion_faenas.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CrearFaenaDTO {

    private Long idTrabajador;

    private String nombreFaena;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // Formato ISO "yyyy-MM-dd"
    private LocalDate fechaInicio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // Formato ISO "yyyy-MM-dd"
    private LocalDate fechaTermino;

    private String encargado;

    private Long idTipoFaena;

}

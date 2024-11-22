package cl.capstone.ms_gestion_faenas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "FAENA")
public class Faena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FAENA", nullable = false)
    private Long idFaena;

    @Column(name = "NOMBRE_FAENA", nullable = false)
    private String nombreFaena;

    @Column(name = "ID_TRABAJADOR", nullable = false)
    private Long idTrabajador;

    @Column(name = "FECHA_INICIO", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "FECHA_TERMINO", nullable = false)
    private LocalDate fechaTermino;

    @Column(name = "ENCARGADO", nullable = false)
    private String encargado;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_FAENA", referencedColumnName = "ID_TIPO_FAENA", nullable = false)
    private TipoFaena tipoFaena;
}

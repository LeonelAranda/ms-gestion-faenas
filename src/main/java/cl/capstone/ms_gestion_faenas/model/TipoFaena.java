package cl.capstone.ms_gestion_faenas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "TIPO_FAENA")
public class TipoFaena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_FAENA", nullable = false)
    private Long idTipoFaena;

    @Column(name = "NOMBRE_FAENA", nullable = false)
    private String nombreFaena;

    @Column(name = "DESCRIPCION_FAENA", nullable = false)
    private String descripcionFaena;
}

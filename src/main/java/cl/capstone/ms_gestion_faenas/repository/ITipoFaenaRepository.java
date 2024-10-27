package cl.capstone.ms_gestion_faenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.capstone.ms_gestion_faenas.model.TipoFaena;

@Repository
public interface ITipoFaenaRepository extends JpaRepository<TipoFaena, Long> {

}

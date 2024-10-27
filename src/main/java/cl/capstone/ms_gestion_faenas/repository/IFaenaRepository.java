package cl.capstone.ms_gestion_faenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.capstone.ms_gestion_faenas.model.Faena;

@Repository
public interface IFaenaRepository extends JpaRepository<Faena, Long> {

}

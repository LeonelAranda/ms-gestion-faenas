package cl.capstone.ms_gestion_faenas.service;

import java.util.List;

import cl.capstone.ms_gestion_faenas.dto.CrearFaenaDTO;
import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;
import cl.capstone.ms_gestion_faenas.model.Faena;

public interface IFaenaService {

    public List<FaenaDTO> getFaenas();

    public void saveFaena(CrearFaenaDTO faena);

    public void deleteFaena(Long id);

    public Faena findFaena(Long id);

    public void editFaena(FaenaDTO faena);

}

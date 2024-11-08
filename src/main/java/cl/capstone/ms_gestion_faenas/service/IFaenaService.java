package cl.capstone.ms_gestion_faenas.service;

import java.util.List;

import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;

public interface IFaenaService {

    public List<FaenaDTO> getFaenas();

    public void saveFaena(FaenaDTO faena);

    public void deleteFaena(Long id);

    public FaenaDTO findFaena(Long id);

    public void editFaena(FaenaDTO faena);

}

package cl.capstone.ms_gestion_faenas.service;

import java.util.List;

import cl.capstone.ms_gestion_faenas.model.Faena;

public interface IFaenaService {

    public List<Faena> getFaenas();

    public void saveFaena(Faena faena);

    public void deleteFaena(Long id);

    public Faena findFaena(Long id);

    public void editFaena(Faena faena);

}

package cl.capstone.ms_gestion_faenas.service;

import java.util.List;

import cl.capstone.ms_gestion_faenas.model.TipoFaena;

public interface ITipoFaenaService {

    public List<TipoFaena> getTipoFaenas();

    public void saveTipoFaena(TipoFaena tipoFaena);

    public void deleteTipoFaena(Long id);

    public TipoFaena findTipoFaena(Long id);

    public void editTipoFaena(Long id, String nombreTipoFaena, String descripcionTipoFaena);

    public void editTipoFaena(TipoFaena tipoFaena);
}

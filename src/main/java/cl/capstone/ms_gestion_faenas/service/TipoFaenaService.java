package cl.capstone.ms_gestion_faenas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_faenas.model.TipoFaena;
import cl.capstone.ms_gestion_faenas.repository.ITipoFaenaRepository;

@Service
public class TipoFaenaService implements ITipoFaenaService {

    @Autowired
    ITipoFaenaRepository tipofaenaRepository;

    @Override
    public List<TipoFaena> getTipoFaenas() {

        List<TipoFaena> listaTipoFaena = tipofaenaRepository.findAll();
        return listaTipoFaena;
    }

    @Override
    public TipoFaena saveTipoFaena(TipoFaena tipoFaena) {

        tipofaenaRepository.save(tipoFaena);
        return tipoFaena;
    }

    @Override
    public void deleteTipoFaena(Long id) {

        tipofaenaRepository.deleteById(id);
    }

    @Override
    public TipoFaena findTipoFaena(Long id) {

        TipoFaena tipoFaena = tipofaenaRepository.findById(id).orElse(null);
        return tipoFaena;
    }

    @Override
    public void editTipoFaena(Long id, String nombreTipoFaena, String descripcionTipoFaena) {

        TipoFaena tipoFaena = this.findTipoFaena(id);
        tipoFaena.setNombreFaena(nombreTipoFaena);
        tipoFaena.setDescripcionFaena(descripcionTipoFaena);

        this.saveTipoFaena(tipoFaena);
    }

    @Override
    public void editTipoFaena(TipoFaena tipoFaena) {

        this.saveTipoFaena(tipoFaena);

    }
}

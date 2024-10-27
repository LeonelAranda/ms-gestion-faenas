package cl.capstone.ms_gestion_faenas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_faenas.model.Faena;
import cl.capstone.ms_gestion_faenas.repository.IFaenaRepository;

@Service
public class FaenaService implements IFaenaService {

    @Autowired
    IFaenaRepository faenaRepository;

    @Override
    public List<Faena> getFaenas() {

        List<Faena> listaFaena = faenaRepository.findAll();
        return listaFaena;
    }

    @Override
    public void saveFaena(Faena faena) {

        faenaRepository.save(faena);
    }

    @Override
    public void deleteFaena(Long id) {

        faenaRepository.deleteById(id);
    }

    @Override
    public Faena findFaena(Long id) {

        Faena faena = faenaRepository.findById(id).orElse(null);
        return faena;
    }

    @Override
    public void editFaena(Faena faena) {

        this.saveFaena(faena);

    }

}

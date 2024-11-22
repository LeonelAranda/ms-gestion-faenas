package cl.capstone.ms_gestion_faenas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_faenas.dto.CrearFaenaDTO;
import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;
import cl.capstone.ms_gestion_faenas.model.Faena;
import cl.capstone.ms_gestion_faenas.repository.IFaenaRepository;

@Service
public class FaenaService implements IFaenaService {

    @Autowired
    IFaenaRepository faenaRepository;

    @Override
    public List<FaenaDTO> getFaenas() {
        List<FaenaDTO> listaDto = new ArrayList<>();
        List<Faena> listaFaena = faenaRepository.findAll();

        for (Faena faena : listaFaena) {
            FaenaDTO dto = new FaenaDTO();
            dto.setNombreFaena(faena.getNombreFaena());
            dto.setIdFaena(faena.getIdFaena());
            dto.setFechaInicio(faena.getFechaInicio());
            dto.setFechaTermino(faena.getFechaTermino());
            dto.setEncargado(faena.getEncargado());

            listaDto.add(dto);
        }

        return listaDto;
    }

    @Override
    public CrearFaenaDTO saveFaena(CrearFaenaDTO faenaDTO) {
        Faena faena = new Faena();

        faena.setNombreFaena(faenaDTO.getNombreFaena());
        faena.setFechaInicio(faenaDTO.getFechaInicio());
        faena.setFechaTermino(faenaDTO.getFechaTermino());
        faena.setEncargado(faenaDTO.getEncargado());

        faenaRepository.save(faena);
        return faenaDTO;
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
    public void editFaena(FaenaDTO faenaDTO) {
        Faena faena = new Faena();
        faena.setIdFaena(faenaDTO.getIdFaena());
        faena.setFechaInicio(faenaDTO.getFechaInicio());
        faena.setFechaTermino(faenaDTO.getFechaTermino());
        faena.setEncargado(faenaDTO.getEncargado());

        // Guarda la entidad Faena mapeada
        faenaRepository.save(faena);
    }

}

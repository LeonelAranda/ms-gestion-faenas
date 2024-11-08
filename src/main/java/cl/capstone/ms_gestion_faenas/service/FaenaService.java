package cl.capstone.ms_gestion_faenas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;
import cl.capstone.ms_gestion_faenas.mapper.FaenaMapper;
import cl.capstone.ms_gestion_faenas.model.Faena;
import cl.capstone.ms_gestion_faenas.repository.IFaenaRepository;

@Service
public class FaenaService implements IFaenaService {

    @Autowired
    private IFaenaRepository faenaRepository;

    @Autowired
    private FaenaMapper faenaMapper;

    @Override
    public List<FaenaDTO> getFaenas() {
        List<Faena> listaFaena = faenaRepository.findAll();
        return listaFaena.stream()
                .map(faenaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveFaena(FaenaDTO faenaDTO) {
        Faena faena = faenaMapper.toEntity(faenaDTO);
        faenaRepository.save(faena);
    }

    @Override
    public void deleteFaena(Long id) {
        faenaRepository.deleteById(id);
    }

    @Override
    public FaenaDTO findFaena(Long id) {
        Faena faena = faenaRepository.findById(id).orElse(null);
        return faena != null ? faenaMapper.toDto(faena) : null;
    }

    @Override
    public void editFaena(FaenaDTO faenaDTO) {
        Faena faena = faenaMapper.toEntity(faenaDTO);
        this.saveFaena(faenaMapper.toDto(faena));
    }
}

package cl.capstone.ms_gestion_faenas.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;
import cl.capstone.ms_gestion_faenas.model.Response;
import cl.capstone.ms_gestion_faenas.service.IFaenaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // CORS para todos los endpoints en esta clase
public class FaenaController {

    @Autowired
    private IFaenaService iFaenaService;

    @PostMapping("/faena/crear")
    public String saveFaena(@RequestBody FaenaDTO faenaDTO) {
        iFaenaService.saveFaena(faenaDTO);
        return "Faena creada";
    }

    @DeleteMapping("/faena/borrar/{id}")
    public ResponseEntity<Response> deleteFaena(@PathVariable Long id) {
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        FaenaDTO faenaDTO = iFaenaService.findFaena(id);

        if (faenaDTO != null) {
            iFaenaService.deleteFaena(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Faena eliminada.");
            response.setResultado(faenaDTO);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró la faena.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/faena/editar")
    public ResponseEntity<FaenaDTO> editFaena(@RequestBody FaenaDTO faenaDTO) {
        iFaenaService.editFaena(faenaDTO);
        FaenaDTO updatedFaenaDTO = iFaenaService.findFaena(faenaDTO.getIdFaena());
        return new ResponseEntity<>(updatedFaenaDTO, HttpStatus.OK);
    }

    @GetMapping("/faena/traer/{id}")
    public ResponseEntity<Response> getFaenaById(@PathVariable Long id) {
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        FaenaDTO faenaDTO = iFaenaService.findFaena(id);

        if (faenaDTO == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Faena no encontrada.");
            response.setResultado(faenaDTO);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Faena encontrada.");
            response.setResultado(faenaDTO);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/faena/traer")
    public ResponseEntity<Response> getFaenas() {
        List<FaenaDTO> faenasDTO = iFaenaService.getFaenas();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (faenasDTO == null || faenasDTO.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Faenas no encontradas.");
            response.setResultado(faenasDTO);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Faenas encontradas.");
            response.setResultado(faenasDTO);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}

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

import cl.capstone.ms_gestion_faenas.dto.CrearFaenaDTO;
import cl.capstone.ms_gestion_faenas.dto.FaenaDTO;
import cl.capstone.ms_gestion_faenas.model.Faena;
import cl.capstone.ms_gestion_faenas.model.Response;
import cl.capstone.ms_gestion_faenas.service.IFaenaService;

@RestController
@CrossOrigin(origins = "https://sistemagf.cl", allowedHeaders = "*") // CORS para todos los endpoints en esta
                                                                             // clase
public class FaenaController {

    @Autowired
    private IFaenaService iFaenaService;

    @GetMapping("/getHttpsService")
    public String getHttpSResponse() {
        return " Respuesta recivida desde HTTPS.";
    }

    @PostMapping("/faena/crear")
    public ResponseEntity<Response> saveFaena(@RequestBody CrearFaenaDTO faena) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        CrearFaenaDTO crearFaenaDTO = iFaenaService.saveFaena(faena);

        // Verificar si se guardó correctamente
        if (crearFaenaDTO != null) {
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Faena creada exitosamente.");
            response.setResultado(crearFaenaDTO);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            // En caso de fallo al guardar el TipoCumplimiento
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("Error al crear la faena.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/faena/borrar/{id}")
    public ResponseEntity<Response> deleteFaena(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        Faena faena = iFaenaService.findFaena(id);

        if (faena != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            iFaenaService.deleteFaena(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Faena eliminada.");
            response.setResultado(faena);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró la faena.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/faena/editar/")
    public Faena editFaena(@RequestBody FaenaDTO faena) {
        iFaenaService.editFaena(faena);

        return iFaenaService.findFaena(faena.getIdFaena());
    }

    @GetMapping("/faena/traer/{id}")
    public ResponseEntity<Response> getTipoFaenaById(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        Faena faena = iFaenaService.findFaena(id);

        if (faena == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Faena no encotrada.");
            response.setResultado(faena);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Faena encontrada.");
            response.setResultado(faena);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/faena/traer")
    public ResponseEntity<Response> getFaena() {

        List<FaenaDTO> faenas = iFaenaService.getFaenas();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (faenas == null || faenas.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Faena no encotradas.");
            response.setResultado(faenas);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Faena encontradas.");
            response.setResultado(faenas);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
}

package cl.capstone.ms_gestion_faenas.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.capstone.ms_gestion_faenas.model.Response;
import cl.capstone.ms_gestion_faenas.model.TipoFaena;
import cl.capstone.ms_gestion_faenas.service.ITipoFaenaService;

@RestController
public class TipoFaenaController {

    @Autowired
    private ITipoFaenaService iTipoFaenaService;

    @PostMapping("/tipofaena/crear")
    public String saveTipoFaena(@RequestBody TipoFaena tipoFaena) {

        // Response response = new Response();
        // LocalDateTime currentDate = LocalDateTime.now();

        iTipoFaenaService.saveTipoFaena(tipoFaena);
        return "Tipo de faena creada";
    }

    @DeleteMapping("/tipofaena/borrar/{id}")
    public ResponseEntity<Response> deleteTipoFaena(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoFaena tipoFaena = iTipoFaenaService.findTipoFaena(id);

        if (tipoFaena != null) {
            // Si existe el trabajador, procedemos a eliminarlo
            iTipoFaenaService.deleteTipoFaena(id);
            response.setCodigoRetorno(0); // Código de éxito
            response.setGlosaRetorno("Tipo de faena eliminado.");
            response.setResultado(tipoFaena);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si el trabajador no existe, retornamos un mensaje de error
            response.setCodigoRetorno(-1); // Código de error
            response.setGlosaRetorno("No se encontró el tipo de faena.");
            response.setResultado(null);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tipofaena/editar/{id}")
    public TipoFaena editTipoFaena(@PathVariable Long id,
            @RequestParam(required = false, name = "tipofaena") String nombreTipoFaena,
            @RequestParam(required = false, name = "descripcion") String descripcionTipoFaena) {

        // Response response = new Response();
        // LocalDateTime currentDate = LocalDateTime.now();

        iTipoFaenaService.editTipoFaena(id, nombreTipoFaena, descripcionTipoFaena);

        TipoFaena tipoFaena = iTipoFaenaService.findTipoFaena(id);

        return tipoFaena;

    }

    @PutMapping("/tipofaena/editar/")
    public TipoFaena editTipoFaena(@RequestBody TipoFaena tipoFaena) {
        iTipoFaenaService.editTipoFaena(tipoFaena);

        return iTipoFaenaService.findTipoFaena(tipoFaena.getIdTipoFaena());
    }

    @GetMapping("/tipofaena/traer/{id}")
    public ResponseEntity<Response> getTipoFaenaById(@PathVariable Long id) {

        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        TipoFaena tipoFaena = iTipoFaenaService.findTipoFaena(id);

        if (tipoFaena == null) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Tipo faena no encotrado.");
            response.setResultado(tipoFaena);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Tipo faena encontrado.");
            response.setResultado(tipoFaena);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/tipofaena/traer")
    public ResponseEntity<Response> getTipoFaena() {

        List<TipoFaena> trabajadores = iTipoFaenaService.getTipoFaenas();
        Response response = new Response();
        LocalDateTime currentDate = LocalDateTime.now();

        if (trabajadores == null || trabajadores.isEmpty()) {
            response.setCodigoRetorno(-1);
            response.setGlosaRetorno("Tipos de faena no encotrados.");
            response.setResultado(trabajadores);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setCodigoRetorno(0);
            response.setGlosaRetorno("Tipos de faena encontrados.");
            response.setResultado(trabajadores);
            response.setTimestamp(currentDate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
}

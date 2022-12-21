package co.edu.unicauca.asae.parcial1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.parcial1.services.services.docenteServices.IDocenteService;

@RestController
@RequestMapping("/api")
@Validated
public class DocenteRestController {
    
    @Autowired
	private IDocenteService docenteService;

	/* 
	@PostMapping("/docentes")
	public ResponseEntity<?> create(@Valid @RequestBody DocenteDTO prmDocente) {
		ResponseEntity<?> response = docenteService.save(prmDocente);
		return response;
	}
	*/

	@GetMapping("/docentes/{id}")
	public ResponseEntity<DocenteDTO> index(@PathVariable int id) {
		ResponseEntity<DocenteDTO> response = this.docenteService.findById(id);
		return response;
	}

	@PostMapping("/docentes")
    public ResponseEntity<?> register(@Valid @RequestBody DocenteDTO docente) {
        ResponseEntity<?> objRespuesta = this.docenteService.register(docente);
    	return objRespuesta;
    }

	@GetMapping("/docentes/exist")
    public ResponseEntity<?> exist(@RequestParam String tipoIdentificacion, @RequestParam String noIdentificacion) {
        DocenteDTO objDocente = this.docenteService.existeDocenteConTipoYNumeroIdentificacion(tipoIdentificacion, noIdentificacion); 
        ResponseEntity<DocenteDTO> objRespuesta = new ResponseEntity<DocenteDTO>(objDocente, HttpStatus.OK);
        return objRespuesta;
    }
}

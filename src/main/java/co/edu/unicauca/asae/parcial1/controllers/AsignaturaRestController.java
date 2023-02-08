package co.edu.unicauca.asae.parcial1.controllers;


import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.services.asignaturaServices.IAsignturaService;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200/")
public class AsignaturaRestController {
    
    @Autowired
	private IAsignturaService asignaturaService;

	@PostMapping("/asignaturas")
	public ResponseEntity<?> create(@Valid @RequestBody AsignaturaDTO prmAsignatura) {		
		ResponseEntity<?> response = asignaturaService.save(prmAsignatura);
		return response;
	}

    @GetMapping("/asignaturas/{id}")
	public ResponseEntity<AsignaturaDTO> show(@PathVariable @Positive(message = "{id.positive}") Integer id) {
		ResponseEntity<AsignaturaDTO> response =  asignaturaService.findById(id);
		return response;
	}

	@GetMapping("/asignaturas")
	public ResponseEntity<?> findAll() {
		ResponseEntity<?> response = asignaturaService.findAll();
		return response;
	}

	/* 
	@GetMapping("/asignaturash/{id}")
	public AsignaturaDTO findByIdH(@PathVariable Integer id) {
		AsignaturaDTO objAsignatura = null;
		objAsignatura = asignaturaService.findByIdPH(id);
		return objAsignatura;
	}
	*/

	@GetMapping("/asignaturas/nombre")
	public ResponseEntity<?> buscarPorNombre(@Valid @RequestParam String nombre){
		ResponseEntity<?> response = this.asignaturaService.buscarPorNombre(nombre);
		return response;
	}

}

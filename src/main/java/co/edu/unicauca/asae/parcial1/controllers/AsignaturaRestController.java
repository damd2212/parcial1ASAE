package co.edu.unicauca.asae.parcial1.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.services.asignaturaServices.IAsignturaService;

@RestController
@RequestMapping("/api")
@Validated
public class AsignaturaRestController {
    
    @Autowired
	private IAsignturaService asignaturaService;

	@PostMapping("/asignaturas")
	public ResponseEntity<?> create(@Valid @RequestBody AsignaturaDTO prmAsignatura) {		
		ResponseEntity<?> response = asignaturaService.save(prmAsignatura);
		return response;
	}

    @GetMapping("/asignaturas/{id}")
	public AsignaturaDTO show(@PathVariable Integer id) {
		AsignaturaDTO objAsignatura = null;
		objAsignatura = asignaturaService.findById(id);
		return objAsignatura;
	}

	@GetMapping("/asignaturash/{id}")
	public AsignaturaDTO findByIdH(@PathVariable Integer id) {
		AsignaturaDTO objAsignatura = null;
		objAsignatura = asignaturaService.findByIdPH(id);
		return objAsignatura;
	}

}

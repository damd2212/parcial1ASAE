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
import org.springframework.http.HttpStatus;

import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.services.asignaturaServices.IAsignturaService;

@RestController
@RequestMapping("/api")
@Validated
public class AsignaturaRestController {
    
    @Autowired
	private IAsignturaService asignaturaService;

	@PostMapping("/asignaturas")
	public AsignaturaDTO create(@Valid @RequestBody AsignaturaDTO prmAsignatura) {
		//Se debe hacer la validación con el try catch para atrapar otro tipo de errores entre las capas?
		//Como se deben asosiar obligatoriamente un curso y dos profesores se debe recibir el id de ellos o los objetos completos?
		//Siempre una asignatura tendrá un solo curso y dos profesoes o puede tener más? en el registro de ser solo y solo un curso y dos docentes?
		//PREGUNTÁR POR QUÉ LAS VALIDACIONES DE LOS OBJETOS INTERNOS NO SE APLICAN

		AsignaturaDTO objAsignatura = null;
		objAsignatura = asignaturaService.save(prmAsignatura);
		return objAsignatura;
	}

    @GetMapping("/asignaturas/{id}")
	public AsignaturaDTO show(@PathVariable Integer id) {
		AsignaturaDTO objAsignatura = null;
		objAsignatura = asignaturaService.findById(id);
		return objAsignatura;
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("nombre del método y parametros erroneos: " + e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}

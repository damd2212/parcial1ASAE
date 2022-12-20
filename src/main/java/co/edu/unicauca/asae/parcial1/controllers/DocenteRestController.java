package co.edu.unicauca.asae.parcial1.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.parcial1.services.services.docenteServices.IDocenteService;

@RestController
@RequestMapping("/api")
@Validated
public class DocenteRestController {
    
    @Autowired
	private IDocenteService docenteService;

	@PostMapping("/docentes")
	public ResponseEntity<?> create(@Valid @RequestBody DocenteDTO prmDocente) {
		DocenteDTO objDocente = null;
		objDocente = docenteService.save(prmDocente);
		return new ResponseEntity<DocenteDTO>(objDocente, HttpStatus.CREATED);
	}

	@GetMapping("/docentes/{id}")
	public DocenteDTO index(@PathVariable int id) {
		DocenteDTO objRta=null;
		objRta=this.docenteService.findById(id);
		return objRta;
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

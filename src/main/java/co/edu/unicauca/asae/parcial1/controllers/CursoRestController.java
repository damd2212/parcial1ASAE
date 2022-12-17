package co.edu.unicauca.asae.parcial1.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.models.Curso;
import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;
import co.edu.unicauca.asae.parcial1.services.services.cursoServices.ICursoService;

@RestController
@RequestMapping("/api")
@Validated
public class CursoRestController {

    @Autowired
	private ICursoService cursoService;

	@PostMapping("/cursos")
	public ResponseEntity<?> create(@Valid @RequestBody CursoDTO prmCurso, @RequestParam("asignatura") Integer id_asignatura) {
		CursoDTO objCurso = null;
		objCurso = cursoService.save(prmCurso,id_asignatura);
		return new ResponseEntity<CursoDTO>(objCurso, HttpStatus.CREATED);
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

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

import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;
import co.edu.unicauca.asae.parcial1.services.services.cursoServices.ICursoService;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200/")
public class CursoRestController {

    @Autowired
	private ICursoService cursoService;

	@PostMapping("/cursos")
	public ResponseEntity<?> create(@Valid @RequestBody CursoDTO prmCurso, @RequestParam("asignatura") Integer id_asignatura) {
		ResponseEntity<?> response = cursoService.save(prmCurso,id_asignatura);
		return response;
	}

	@GetMapping("/cursos/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		ResponseEntity<?> response = cursoService.findById(id);
		return response;
	}

	@GetMapping("/cursos")
	public ResponseEntity<?> findAll() {
		ResponseEntity<?> response = cursoService.findAll();
		return response;
	}

}

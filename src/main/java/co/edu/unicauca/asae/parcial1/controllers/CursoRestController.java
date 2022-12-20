package co.edu.unicauca.asae.parcial1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public class CursoRestController {

    @Autowired
	private ICursoService cursoService;

	@PostMapping("/cursos")
	public ResponseEntity<?> create(@Valid @RequestBody CursoDTO prmCurso, @RequestParam("asignatura") Integer id_asignatura) {
		ResponseEntity<?> response = cursoService.save(prmCurso,id_asignatura);
		return response;
	}

}

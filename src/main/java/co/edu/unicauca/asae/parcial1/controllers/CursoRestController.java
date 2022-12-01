package co.edu.unicauca.asae.parcial1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;
import co.edu.unicauca.asae.parcial1.services.services.cursoServices.ICursoService;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    @Autowired
	private ICursoService cursoService;

	@PostMapping("/cursos/{id_asignatura}")
	public CursoDTO create(@RequestBody CursoDTO prmCurso, @PathVariable Integer id_asignatura) {
		CursoDTO objCurso = null;
		objCurso = cursoService.save(prmCurso,id_asignatura);
		return objCurso;
	}
}

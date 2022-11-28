package co.edu.unicauca.asae.parcial1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.parcial1.services.services.docenteServices.IDocenteService;

@RestController
@RequestMapping("/api")
public class DocenteRestController {
    
    @Autowired
	private IDocenteService docenteService;

	@PostMapping("/docentes")
	public DocenteDTO create(@RequestBody DocenteDTO prmDocente) {
		DocenteDTO objDocente = null;
		objDocente = docenteService.save(prmDocente);
		return objDocente;
	}
}

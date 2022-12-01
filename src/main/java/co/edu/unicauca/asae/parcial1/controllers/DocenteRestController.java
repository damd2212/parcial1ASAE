package co.edu.unicauca.asae.parcial1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class DocenteRestController {
    
    @Autowired
	private IDocenteService docenteService;

	@PostMapping("/docentes")
	public DocenteDTO create(@RequestBody DocenteDTO prmDocente) {
		DocenteDTO objDocente = null;
		objDocente = docenteService.save(prmDocente);
		return objDocente;
	}
	@GetMapping("/docentes/{id}")
	public DocenteDTO index(@PathVariable int id) {
		DocenteDTO objRta=null;
		objRta=this.docenteService.findById(id);
		return objRta;
	}
}

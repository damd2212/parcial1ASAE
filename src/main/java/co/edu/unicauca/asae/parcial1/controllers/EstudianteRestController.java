package co.edu.unicauca.asae.parcial1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.parcial1.services.services.estudianteServices.IEstudianteService;

@RestController
@RequestMapping("/api")
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO findById(@PathVariable Integer id){
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findById(id);
        return objEstudainte;
    }
    @GetMapping("/estudiantesEager/{id}")
    public EstudianteDTO findByIdEager(@PathVariable Integer id){
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findById(id);
        return objEstudainte;
    }
}

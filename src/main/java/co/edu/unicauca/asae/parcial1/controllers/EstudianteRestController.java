package co.edu.unicauca.asae.parcial1.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.parcial1.services.services.estudianteServices.IEstudianteService;

@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estudianteService;
    
    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO estudiante) {
        EstudianteDTO objEstudiante = this.estudianteService.save(estudiante);
        ResponseEntity<EstudianteDTO> objRespuesta = new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.CREATED);
    	return objRespuesta;
    }
    
    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO findById(@PathVariable Integer id){
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findById(id);
        return objEstudainte;
    }

    @GetMapping("/estudiantesg/{id}")
    public EstudianteDTO findByIdG(@PathVariable Integer id){
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findByIdG(id);
        return objEstudainte;
    }

    @GetMapping("/estudiantesEager/{id}")
    public EstudianteDTO findByIdEager(@PathVariable Integer id){
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findById(id);
        return objEstudainte;
    }

    @PutMapping("/estudiantes/{id}")
	public EstudianteDTO update(@Valid @RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
		EstudianteDTO objEstudiante = null;
		EstudianteDTO estudianteActual = estudianteService.findById(id);
		if (estudianteActual != null) {
			objEstudiante = estudianteService.update(id, estudiante);
		}
		return objEstudiante;
	}
    
    @DeleteMapping("/estudiantes/{id}")
    public Boolean delete(@PathVariable Integer id) {
    	Boolean bandera = false;
    	EstudianteDTO objEstudiante= this.estudianteService.findById(id);
    	if(objEstudiante != null) {
    		bandera = this.estudianteService.delete(id);
    	}
    	return bandera;
    }
}

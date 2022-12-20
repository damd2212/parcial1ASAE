package co.edu.unicauca.asae.parcial1.controllers;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.parcial1.services.services.estudianteServices.IEstudianteService;


@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estudianteService;

    @PostMapping("/estudiantes")
    public ResponseEntity<?> create(@Valid @RequestBody EstudianteDTO estudiante) {
        ResponseEntity<?> response =  this.estudianteService.save(estudiante);
        return response;
    }

    @GetMapping("/estudiantes/{id}")
    public EstudianteDTO findById(@PathVariable Integer id) {
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findById(id);
        return objEstudainte;
    }

    @GetMapping("/estudiantesg/{id}")
    public EstudianteDTO findByIdG(@PathVariable Integer id) {
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findByIdG(id);
        return objEstudainte;
    }

    @GetMapping("/estudiantesEager/{id}")
    public EstudianteDTO findByIdEager(@PathVariable Integer id) {
        EstudianteDTO objEstudainte = null;
        objEstudainte = estudianteService.findById(id);
        return objEstudainte;
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
        ResponseEntity<EstudianteDTO> response = estudianteService.update(id, estudiante);
        return response;        
    }

    @DeleteMapping("/estudiantes/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        bandera = this.estudianteService.delete(id); 
        return bandera;
    }

    @GetMapping("/estudiantes/nombres_apellidos_email")
    public ResponseEntity<List<EstudianteDTO>> buscarPorNombresApellidosEmail(@RequestParam String nombres,
            @RequestParam String apellidos, @RequestParam String correoElectronico) {
        if(nombres.length()==0){
            nombres=" ";
        }
        if(apellidos.length()==0){
            apellidos=" ";
        }
        if(correoElectronico.length()==0){
            correoElectronico=" ";
        }
        ResponseEntity<List<EstudianteDTO>> response =  this.estudianteService.buscarPorNombresApellidosEmail(nombres, apellidos, correoElectronico);
        return response;
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> showRangoClientes(@RequestBody Collection<Integer> conjuntoIds) {
        ResponseEntity<List<EstudianteDTO>> response =  this.estudianteService.findByIdEnConjunto(conjuntoIds);
        return response;
    }

  
}

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
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estudianteService;

    @PostMapping("/estudiantes")
    public ResponseEntity<?> create(@Valid @RequestBody EstudianteDTO estudiante) {
        EstudianteDTO objEstudiante = null;
        objEstudiante = this.estudianteService.save(estudiante);
        return new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.CREATED);
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
    public ResponseEntity<?> update(@Valid @RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
        EstudianteDTO objEstudiante = null;
        EstudianteDTO estudianteActual = estudianteService.findById(id);
        if (estudianteActual != null) {
            objEstudiante = estudianteService.update(id, estudiante);
        }else{
            return new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.NOT_FOUND);
        }
        if(objEstudiante!=null){
            return new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.OK);
        }else{
            return new ResponseEntity<EstudianteDTO>(objEstudiante, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping("/estudiantes/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Boolean bandera = false;
        bandera = this.estudianteService.delete(id); 
        return bandera;
    }

    @GetMapping("/estudiantes/nombres_apellidos_email")
    public ResponseEntity<?> buscarPorNombresApellidosEmail(@RequestParam String nombres,
            @RequestParam String apellidos, @RequestParam String correoElectronico) {
        List<EstudianteDTO> lista = null;
        if(nombres.length()==0){
            nombres=" ";
        }
        if(apellidos.length()==0){
            apellidos=" ";
        }
        if(correoElectronico.length()==0){
            correoElectronico=" ";
        }
        lista = this.estudianteService.buscarPorNombresApellidosEmail(nombres, apellidos, correoElectronico);
        if (lista.size() <= 0) {
            return new ResponseEntity<List<EstudianteDTO>>(lista, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EstudianteDTO>>(lista, HttpStatus.OK);
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<?> showRangoClientes(@RequestBody Collection<Integer> conjuntoIds) {
        System.out.println(conjuntoIds);
        List<EstudianteDTO> lista = null;
        lista = this.estudianteService.findByIdEnConjunto(conjuntoIds);
        if (lista.size() <= 0) {
            return new ResponseEntity<List<EstudianteDTO>>(lista, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EstudianteDTO>>(lista, HttpStatus.OK);
    }

  
}

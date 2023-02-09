package co.edu.unicauca.asae.parcial1.controllers;


import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estudianteService;
    
    @PostMapping("/estudiantes")
    public ResponseEntity<?> register(@Valid @RequestBody EstudianteDTO estudiante) {
        ResponseEntity<?> objRespuesta = this.estudianteService.register(estudiante);
    	return objRespuesta;
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable @Positive(message = "{id.positive}") Integer id) {
        ResponseEntity<EstudianteDTO> response =  estudianteService.findById(id);
        return response;
    }

    /* 
    @PostMapping("/estudiantes")
    public ResponseEntity<?> create(@Valid @RequestBody EstudianteDTO estudiante) {
        ResponseEntity<?> response =  this.estudianteService.save(estudiante);
        return response;
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
    */

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
        ResponseEntity<EstudianteDTO> response = estudianteService.update(id, estudiante);
        return response;        
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        ResponseEntity<Boolean> response = this.estudianteService.delete(id); 
        return response;
    }

    @GetMapping("/estudiantes/exist")
    public ResponseEntity<?> exist(@RequestParam String tipoIdentificacion, @RequestParam String noIdentificacion) {
        EstudianteDTO objStudent = this.estudianteService.existeEstudianteConTipoYNumeroIdentificacion(tipoIdentificacion, noIdentificacion); 
        ResponseEntity<EstudianteDTO> objRespuesta = new ResponseEntity<EstudianteDTO>(objStudent, HttpStatus.OK);
        return objRespuesta;
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

    @PostMapping("/estudiantes/buscar")
    public ResponseEntity<List<EstudianteDTO>> buscarByIdsEstudiantes(@RequestBody Collection<Integer> conjuntoIds) {
        ResponseEntity<List<EstudianteDTO>> response =  this.estudianteService.findByIdEnConjunto(conjuntoIds);
        return response;
    }

    @GetMapping("/estudiantes/todos")
    public ResponseEntity<List<EstudianteDTO>> findAll(){
        ResponseEntity<List<EstudianteDTO>> response = this.estudianteService.findAll();
        return response;
    }
    
    @GetMapping("/estudiantes/buscarPorEmail")
    public ResponseEntity<EstudianteDTO> buscarPorEmail(@RequestParam String correoElectronico){
    	ResponseEntity<EstudianteDTO> response = this.estudianteService.findByEmail(correoElectronico);
    	return response;
    }
}

package co.edu.unicauca.asae.parcial1.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.parcial1.services.services.estudianteServices.IEstudianteService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
@Validated()
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estudianteService;

    @PostMapping("/estudiantes")
    public EstudianteDTO create(@RequestBody EstudianteDTO estudiante) {
        EstudianteDTO objEstudiante = null;
        objEstudiante = this.estudianteService.save(estudiante);
        return objEstudiante;
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
    public EstudianteDTO update(@RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
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
        EstudianteDTO objEstudiante = this.estudianteService.findById(id);
        if (objEstudiante != null) {
            bandera = this.estudianteService.delete(id);
        }
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

    @GetMapping("/estudiantes/{id1}/{id2}")
    public ResponseEntity<?> showRangoClientes(@PathVariable Integer id1, @PathVariable Integer id2) {
        List<EstudianteDTO> lista = null;
        System.out.println("Buscando en el rango: " + id1 + " y " + id2);
        lista = this.estudianteService.findByIdPorRango(id1, id2);
        if (lista.size() <= 0) {
            return new ResponseEntity<List<EstudianteDTO>>(lista, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EstudianteDTO>>(lista, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<String> handleConstraintViolationException(NoSuchElementException e) {
        return new ResponseEntity<>("El estudiante no existe en la  BD",
                HttpStatus.NOT_FOUND);
    }
}

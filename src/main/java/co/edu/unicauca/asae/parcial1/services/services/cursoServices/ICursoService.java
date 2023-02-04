package co.edu.unicauca.asae.parcial1.services.services.cursoServices;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;

public interface ICursoService {
    public ResponseEntity<?> save(CursoDTO prmCurso, int id_asignatura);
    public ResponseEntity<?> findById(String prmId);
    public ResponseEntity<?> findAll();
}

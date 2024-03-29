package co.edu.unicauca.asae.parcial1.services.services.docenteServices;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;

public interface IDocenteService {
    public ResponseEntity<?> save(DocenteDTO prmDocente);
    public ResponseEntity<DocenteDTO> findById(int prmId);
    public List<DocenteDTO> findAll();
    public ResponseEntity<?> findAlln();
    public ResponseEntity<?> register(DocenteDTO prmDocente);
    public DocenteDTO existeDocenteConTipoYNumeroIdentificacion(String tipoIdentificacion, String noIdentificacion);
}

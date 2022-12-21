package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;


import org.springframework.http.ResponseEntity;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

public interface IAsignturaService {
    public ResponseEntity<?> save(AsignaturaDTO prmAsignatura);
    public ResponseEntity<AsignaturaDTO> findById(Integer id);
    /* 
    public AsignaturaDTO findByIdPH(Integer id);
    */
    public ResponseEntity<?> buscarPorNombre(String nombre);
}

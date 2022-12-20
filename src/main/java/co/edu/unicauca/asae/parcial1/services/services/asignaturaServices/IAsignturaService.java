package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.parcial1.response.AsignaturaRes.AsignaturaResponseRest;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

public interface IAsignturaService {
    public AsignaturaDTO save(AsignaturaDTO prmAsignatura);
    public AsignaturaDTO findById(Integer id);
    public AsignaturaDTO findByIdPH(Integer id);

    public ResponseEntity<AsignaturaResponseRest> buscarPorNombre(String nombre);
}

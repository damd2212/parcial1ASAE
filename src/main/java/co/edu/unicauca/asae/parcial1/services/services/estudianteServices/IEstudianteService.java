package co.edu.unicauca.asae.parcial1.services.services.estudianteServices;



import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;

import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;

public interface IEstudianteService {

    public ResponseEntity<List<EstudianteDTO>> findAll();
	
	public ResponseEntity<?> save(EstudianteDTO estudiante);
	
    public ResponseEntity<EstudianteDTO> findById(Integer idEstudainte);

    public EstudianteDTO findByIdG(Integer idEstudainte);

    public ResponseEntity<EstudianteDTO> update(Integer id, EstudianteDTO estudiante);
    
    public ResponseEntity<Boolean> delete(Integer id);


    public ResponseEntity<?> register(EstudianteDTO estudiante);

    
    public ResponseEntity<List<EstudianteDTO>> buscarPorNombresApellidosEmail(String nombres,String apellidos, String correoElectronico);

    public EstudianteDTO existeEstudianteConTipoYNumeroIdentificacion(String tipoIdentificacion,String noIdentificacion);
    public ResponseEntity<List<EstudianteDTO>> findByIdEnConjunto(Collection<Integer> conjuntoIds);
    

}

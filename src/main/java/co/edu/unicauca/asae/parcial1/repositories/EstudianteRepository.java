package co.edu.unicauca.asae.parcial1.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.models.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{

    public List<Estudiante> findByNombresIgnoreCaseContainingOrApellidosIgnoreCaseContainingOrCorreoElectronicoIgnoreCaseContaining(String nombres,String apellidos,String correoElectronico);
    
    public List<Estudiante> findByIdPersonaIn(Collection<Integer> conjuntoIds);

    //public boolean findBynoIdentificacionAndtipoIdentificacion(String nombres,String apellidos);

    @Query(
        value = "SELECT * FROM Estudiante est WHERE est.noIdentificacion = ? AND est.tipoIdentificacion = ?",
        nativeQuery = true
    )
    public Estudiante findEstudianteByIdAndTipo(String noIdent, String tipoIdent);    
} 

package co.edu.unicauca.asae.parcial1.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.models.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{


    public List<Estudiante> findByNombresIgnoreCaseContainingOrApellidosIgnoreCaseContainingOrCorreoElectronicoIgnoreCaseContaining(String nombres,String apellidos,String correoElectronico);
    
    public List<Estudiante> findByIdPersonaIn(Collection<Integer> conjuntoIds);
    
    @Query(value="Select * from Estudiante where correoElectronico = :correoElectronico", nativeQuery = true)
    public Estudiante findByCorreoElectronico(@Param("correoElectronico") String correoElectronico);

    @Query(value="SELECT * FROM Estudiante u WHERE u.tipoIdentificacion = :tipo and u.noIdentificacion = :numero",nativeQuery = true)
	public Estudiante findByTipoDeIdentificacionYnumeroDeIdentificacion(@Param("tipo") String tipoIdentificacion,@Param("numero") String noIdentificacion);

} 

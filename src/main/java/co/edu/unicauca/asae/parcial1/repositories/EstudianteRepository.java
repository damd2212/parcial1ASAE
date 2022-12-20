package co.edu.unicauca.asae.parcial1.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.parcial1.models.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{

    @Query(
        value = "SELECT * FROM Estudiante est WHERE est.noIdentificacion = ? AND est.tipoIdentificacion = ?",
        nativeQuery = true
    )
    public Estudiante findEstudianteByIdAndTipo(String noIdent, String tipoIdent);

    @Query(value="Select * from Estudiante where correoElectronico = :correoElectronico", nativeQuery = true)
    public Estudiante findByCorreoElectronico(@Param("correoElectronico") String correoElectronico);

    
} 

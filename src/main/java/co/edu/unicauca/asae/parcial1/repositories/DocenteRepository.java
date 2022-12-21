package co.edu.unicauca.asae.parcial1.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.parcial1.models.Docente;

public interface DocenteRepository extends CrudRepository<Docente,Integer>{
    @Query(
        value = "SELECT * FROM Docente doc WHERE doc.noIdentificacion = ? AND doc.tipoIdentificacion = ?",
        nativeQuery = true
    )
    public Docente findEstudianteByIdAndTipo(String noIdent, String tipoIdent);

}

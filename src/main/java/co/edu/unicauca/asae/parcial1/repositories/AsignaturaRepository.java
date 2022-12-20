package co.edu.unicauca.asae.parcial1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.parcial1.models.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura,Integer>{
    public List<Asignatura> findByNombreIgnoreCaseContainingOrderByNombreAsc(String nombre);
}

package co.edu.unicauca.asae.parcial1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.parcial1.models.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{

    public List<Estudiante> findByNombresIgnoreCaseContainingOrApellidosIgnoreCaseContainingOrCorreoElectronicoIgnoreCaseContaining(String nombres,String apellidos,String correoElectronico);
    
    public List<Estudiante> findByIdPersonaBetween(int id1, int id2);
} 

package co.edu.unicauca.asae.parcial1.services.services.estudianteServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.repositories.EstudianteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{


    @Autowired
    private EstudianteRepository servicioAccesoBDestudiante;

    @Autowired
    private ModelMapper estudainteModelMapper;

    @Override
    public EstudianteDTO findById(Integer idEstudainte) {

        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(idEstudainte); 
        if (optional.isPresent()) {
            Estudiante estudiante = optional.get();
            System.out.println("Antes de consultar los datos");
            EstudianteDTO estudianteDTO = this.estudainteModelMapper.map(estudiante,EstudianteDTO.class);
            return estudianteDTO;
        }else{
            System.out.println("Estudiante no encontrado");
        }
        return null;
    }
    
}

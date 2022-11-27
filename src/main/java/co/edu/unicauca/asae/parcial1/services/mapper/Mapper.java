package co.edu.unicauca.asae.parcial1.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        //TypeMap<Asignatura, AsignaturaDTO> mapa = objMapper.emptyTypeMap(Asignatura.class, AsignaturaDTO.class);
        
        // mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        //mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        //mapa.addMappings(m -> m.skip(AsignaturaDTO::setListaCursos)).implicitMappings();



        /*-------------------------------- 
         * Mapper para el estudiante
        */

        TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
        
        mapa.addMappings(m -> m.skip(EstudianteDTO::setObjDireccion)).implicitMappings();
        mapa.addMappings(m -> m.skip(EstudianteDTO::setListaTelefonos)).implicitMappings();
        
        //mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        //mapa.addMappings(m -> m.skip(AsignaturaDTO::setListaCursos)).implicitMappings();

        return objMapper;
    }
}

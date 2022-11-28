package co.edu.unicauca.asae.parcial1.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;

@Configuration
public class Mapper {
    @Bean(name = "otro")
    public ModelMapper modelMapperAsig() {
        ModelMapper objMapper = new ModelMapper();
        /*----------------------------
         * Mappper para Asignatura
         */
        //TypeMap<Asignatura, AsignaturaDTO> mapa = objMapper.emptyTypeMap(Asignatura.class, AsignaturaDTO.class);
        //Para el punto I donde solicitan no mostrar los cursos
        //mapa.addMappings(m -> m.skip(AsignaturaDTO::setListaCursos)).implicitMappings();
        
        /*----------------------------
         * Mappper para quitar el tipo de docente punto H
         */
        //TypeMap<Docente, DocenteDTO> mapa = objMapper.emptyTypeMap(Docente.class, DocenteDTO.class);
        //mapa.addMappings(m -> m.skip(DocenteDTO::setTipoDocente)).implicitMappings();


        /*-------------------------------- 
         * Mapper para el estudiante
        */
        //Para el Punto f comentamos 
        //TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
         
        //Para el punto G donde solicitan no mostrar ni los telefonos ni la direccion
        //mapa.addMappings(m -> m.skip(EstudianteDTO::setObjDireccion)).implicitMappings();
        //mapa.addMappings(m -> m.skip(EstudianteDTO::setListaTelefonos)).implicitMappings();
        
        //mapa.addMappings(m -> m.skip(AsignaturaDTO::setListaCursos)).implicitMappings();

        return objMapper;
    }


    @Bean(name = "mapperbase")
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        return objMapper;
    }

    @Bean(name = "mapperpuntog")
    public ModelMapper modelMapperEstudianteG() {
        ModelMapper objMapper = new ModelMapper();
        /*-------------------------------- 
         * Mapper para el estudiante
         * Para el punto G donde solicitan no mostrar ni los telefonos ni la direccion
        */
        TypeMap<Estudiante, EstudianteDTO> mapa = objMapper.emptyTypeMap(Estudiante.class, EstudianteDTO.class);
        mapa.addMappings(m -> m.skip(EstudianteDTO::setObjDireccion)).implicitMappings();
        mapa.addMappings(m -> m.skip(EstudianteDTO::setListaTelefonos)).implicitMappings();

        return objMapper;
    }

    @Bean(name = "mapperpuntoh")
    public ModelMapper modelMapperAsigH() {
        ModelMapper objMapper = new ModelMapper();        
        /*----------------------------
         * Mappper para quitar el tipo de docente punto H
         */
        TypeMap<Docente, DocenteDTO> mapa = objMapper.emptyTypeMap(Docente.class, DocenteDTO.class);
        mapa.addMappings(m -> m.skip(DocenteDTO::setTipoDocente)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "mapperpuntoi")
    public ModelMapper modelMapperAsigI() {
        ModelMapper objMapper = new ModelMapper();
        /*----------------------------
         * Mappper para Asignatura 
         * Para el punto I donde solicitan no mostrar los cursos
         */
        TypeMap<Asignatura, AsignaturaDTO> mapa = objMapper.emptyTypeMap(Asignatura.class, AsignaturaDTO.class);
        mapa.addMappings(m -> m.skip(AsignaturaDTO::setListaCursos)).implicitMappings();
        return objMapper;
    }

}

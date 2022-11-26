package co.edu.unicauca.asae.parcial1.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

@Configuration
public class AsignaturaMapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<Asignatura, AsignaturaDTO> mapa = objMapper.emptyTypeMap(Asignatura.class, AsignaturaDTO.class);
        // mapa.addMappings(m ->
        // m.skip(ClienteDTO::setObjDireccion)).implicitMappings();
        // mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        //mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        return objMapper;
    }
}

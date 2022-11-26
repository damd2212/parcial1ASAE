package co.edu.unicauca.asae.parcial1.services.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DireccionMapper {
    //@Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        //TypeMap<ClienteEntity, ClienteDTO> mapa = objMapper.emptyTypeMap(ClienteEntity.class, ClienteDTO.class);
        // mapa.addMappings(m ->
        // m.skip(ClienteDTO::setObjDireccion)).implicitMappings();
        // mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        //mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        return objMapper;
    }
}

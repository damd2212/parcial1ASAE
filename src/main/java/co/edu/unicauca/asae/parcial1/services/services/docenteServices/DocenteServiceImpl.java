package co.edu.unicauca.asae.parcial1.services.services.docenteServices;

import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.repositories.DocenteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements IDocenteService{

    @Autowired
	private DocenteRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;
    
    @Override
    @Transactional()
    public DocenteDTO save(DocenteDTO prmDocente) {
        Docente objDocente=this.modelMapper.map(prmDocente, Docente.class);
        Docente objDocenteRespuesta=this.servicioAccesoBaseDatos.save(objDocente);
        DocenteDTO objDocenteDTO=this.modelMapper.map(objDocenteRespuesta, DocenteDTO.class);
        return objDocenteDTO;
    }

}

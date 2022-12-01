package co.edu.unicauca.asae.parcial1.services.services.docenteServices;

import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.repositories.DocenteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements IDocenteService{

    @Autowired
	private DocenteRepository servicioAccesoBaseDatos;

	@Autowired
	@Qualifier("mapperbase")
	private ModelMapper modelMapper;
    
    @Override
    @Transactional()
    public DocenteDTO save(DocenteDTO prmDocente) {
        Docente objDocente=this.modelMapper.map(prmDocente, Docente.class);
        Docente objDocenteRespuesta=this.servicioAccesoBaseDatos.save(objDocente);
        DocenteDTO objDocenteDTO=this.modelMapper.map(objDocenteRespuesta, DocenteDTO.class);
        return objDocenteDTO;
    }
    @Override
    @Transactional
    public DocenteDTO findById(int prmId){
        Optional<Docente> objDocente=this.servicioAccesoBaseDatos.findById(prmId);
        DocenteDTO objDocenteDTO=null;
        if(objDocente.isPresent()){
            objDocenteDTO=this.modelMapper.map(objDocente.get(),DocenteDTO.class);
        }
        return objDocenteDTO;
    }
    @Override
    @Transactional
    public List<DocenteDTO> findAll(){
        Iterable<Docente> obj=this.servicioAccesoBaseDatos.findAll();
        List<DocenteDTO> rta=this.modelMapper.map(obj, new TypeToken<List<DocenteDTO>>(){}.getType());
        return rta;
    }

}

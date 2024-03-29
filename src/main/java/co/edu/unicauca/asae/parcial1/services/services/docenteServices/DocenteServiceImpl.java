package co.edu.unicauca.asae.parcial1.services.services.docenteServices;

import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadYaExisteException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> save(DocenteDTO prmDocente) {
        Docente objDocente=this.modelMapper.map(prmDocente, Docente.class);
        Docente objDocenteRespuesta=this.servicioAccesoBaseDatos.save(objDocente);
        DocenteDTO objDocenteDTO=this.modelMapper.map(objDocenteRespuesta, DocenteDTO.class);
        if(objDocenteDTO!=null){
            return new ResponseEntity<DocenteDTO>(objDocenteDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Error al almacenar el docente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<DocenteDTO> findById(int prmId){
        Optional<Docente> objDocente=this.servicioAccesoBaseDatos.findById(prmId);
        DocenteDTO objDocenteDTO=null;
        if(objDocente.isPresent()){
            objDocenteDTO=this.modelMapper.map(objDocente.get(),DocenteDTO.class);
        }else{
            EntidadNoExisteException objNoExisteException = new EntidadNoExisteException("El docente con id " + prmId + " no existe en la base de datos");
            throw objNoExisteException;
        }
        return new ResponseEntity<DocenteDTO>(objDocenteDTO, HttpStatus.OK);
    }

    @Override
    @Transactional
    public List<DocenteDTO> findAll(){
        Iterable<Docente> obj=this.servicioAccesoBaseDatos.findAll();
        List<DocenteDTO> rta=this.modelMapper.map(obj, new TypeToken<List<DocenteDTO>>(){}.getType());
        return rta;
    }

    @Override
    public ResponseEntity<?> register(DocenteDTO prmDocente) {
        Docente objDocente = this.servicioAccesoBaseDatos.findDocenteByIdAndTipo(prmDocente.getNoIdentificacion(), prmDocente.getTipoIdentificacion());
        
        System.out.println("--------------");
        System.out.println(objDocente);
        System.out.println("--------------");
        if (objDocente != null) {
            EntidadYaExisteException objException = new EntidadYaExisteException("Docente con identificacion: " + prmDocente.getNoIdentificacion() + " de tipo " + prmDocente.getTipoIdentificacion() +" ya existe en la base de datos");
            throw objException;
        }
        Docente objDocenteRetorno=this.modelMapper.map(prmDocente, Docente.class);
        Docente objDocenteRespuesta=this.servicioAccesoBaseDatos.save(objDocenteRetorno);
        DocenteDTO objDocenteDTO=this.modelMapper.map(objDocenteRespuesta, DocenteDTO.class);
        if(objDocenteDTO!=null){
            return new ResponseEntity<DocenteDTO>(objDocenteDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Error al almacenar el docente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public DocenteDTO existeDocenteConTipoYNumeroIdentificacion(String tipoIdentificacion, String noIdentificacion) {

        DocenteDTO objDocenteDTO=null;
        Docente objDocenteR=this.servicioAccesoBaseDatos.findDocenteByIdAndTipo(noIdentificacion,tipoIdentificacion);
        if(objDocenteR==null){
            EntidadNoExisteException objException = new EntidadNoExisteException("Docente con Tipo Identificacion: "+tipoIdentificacion+" e identificación: "+noIdentificacion+" no existe en la BD");
            throw objException;
        }else{
            objDocenteDTO=this.modelMapper.map(objDocenteR, DocenteDTO.class);
        }
        return objDocenteDTO;
    }

    @Override
    @Transactional
    public ResponseEntity<List<DocenteDTO>> findAlln(){
        Iterable<Docente> obj=this.servicioAccesoBaseDatos.findAll();
        List<DocenteDTO> rta=this.modelMapper.map(obj, new TypeToken<List<DocenteDTO>>(){}.getType());   
        return new ResponseEntity<List<DocenteDTO>>(rta, HttpStatus.OK);
    }

}

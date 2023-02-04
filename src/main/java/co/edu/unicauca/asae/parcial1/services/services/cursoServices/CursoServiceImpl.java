package co.edu.unicauca.asae.parcial1.services.services.cursoServices;

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

import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.models.Curso;
import co.edu.unicauca.asae.parcial1.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.parcial1.repositories.CursoRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;

@Service
public class CursoServiceImpl implements ICursoService{

    @Autowired
	private CursoRepository servicioAccesoBaseDatos;

    @Autowired
    private AsignaturaRepository servicioAccesoBaseDatosAsig;
    
	@Autowired
	@Qualifier("mapperbase")
	private ModelMapper modelMapper;

    /* 
     * Método que permite guardar un curso en la base de datos
     * prmCurso = objeto de tipo cursoDTO
     * Return = objeto de tipo cursoDTO
     */
    @Override
    @Transactional()
    public ResponseEntity<?> save(CursoDTO prmCurso, int id_asignatura) {
        if(prmCurso.getIdCurso()!=null){
            Optional<Curso> optionalc = this.servicioAccesoBaseDatos.findById(prmCurso.getIdCurso());
            if(optionalc.isPresent()){
                EntidadYaExisteException exception = new EntidadYaExisteException("Curso con id "+prmCurso.getIdCurso()+" ya existe en la BD");
                throw exception;
            }
        }
        Optional<Asignatura> optionala = this.servicioAccesoBaseDatosAsig.findById(id_asignatura);
        if(optionala.isPresent()==false){
            EntidadNoExisteException exception = new EntidadNoExisteException("Asignatura con id "+id_asignatura+" no existe en la BD");
            throw exception;
        }
        CursoDTO objCursoDTO = null;
        Optional<Asignatura> optional = this.servicioAccesoBaseDatosAsig.findById(id_asignatura);
        Optional<Curso> optional2 = this.servicioAccesoBaseDatos.findById(prmCurso.getIdCurso());
        if(optional.isPresent() && !optional2.isPresent()){
            Curso objCurso =this.modelMapper.map(prmCurso, Curso.class);
            Asignatura asignatura = optional.get();
            objCurso.setObjAsignatura(asignatura);
            Curso objCursoRespuesta=this.servicioAccesoBaseDatos.save(objCurso);
            objCursoDTO=this.modelMapper.map(objCursoRespuesta, CursoDTO.class);
        }else{
            return new ResponseEntity<String>("Error al almacenar el curso", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CursoDTO>(objCursoDTO, HttpStatus.CREATED);
    }


    @Override
    @Transactional
    public ResponseEntity<?> findById(String prmId){
        Optional<Curso> objCurso=this.servicioAccesoBaseDatos.findById(prmId);
        CursoDTO objCursoDTO=null;
        if(objCurso.isPresent()){
            System.out.println(objCurso.get().getObjAsignatura().getNombre());
            objCursoDTO=this.modelMapper.map(objCurso.get(),CursoDTO.class);
            
        }else{
            EntidadNoExisteException objNoExisteException = new EntidadNoExisteException("El curso con id " + prmId + " no existe en la base de datos");
            throw objNoExisteException;
        }
        return new ResponseEntity<CursoDTO>(objCursoDTO, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<List<CursoDTO>> findAll(){
        Iterable<Curso> obj=this.servicioAccesoBaseDatos.findAll();
        List<CursoDTO> rta=this.modelMapper.map(obj, new TypeToken<List<CursoDTO>>(){}.getType());   
        return new ResponseEntity<List<CursoDTO>>(rta, HttpStatus.OK);
    }
}

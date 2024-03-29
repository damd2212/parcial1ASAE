package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.NoContentException;
import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.models.Curso;
import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.parcial1.repositories.CursoRepository;
import co.edu.unicauca.asae.parcial1.repositories.DocenteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignturaService {

    @Autowired
    private AsignaturaRepository servicioAccesoBaseDatos;
    @Autowired
    private DocenteRepository servicioADDocente;
    @Autowired 
    private CursoRepository servicioADCurso;

    @Autowired
    @Qualifier("mapperpuntoi")
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("mapperpuntoh")
    private ModelMapper modelMapperH;

    @Autowired
    @Qualifier("mapperbase")
    private ModelMapper modelMapperB;

    @Autowired
    @Qualifier("mapperAsignaturas")
    private ModelMapper modelMapperAsig;
    
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<AsignaturaDTO> findById(Integer id) {
        Optional<Asignatura> optional = this.servicioAccesoBaseDatos.findById(id);
        Asignatura asignatura = optional.get();
        AsignaturaDTO asignaturaDTO = this.modelMapperB.map(asignatura, AsignaturaDTO.class);
        if(asignaturaDTO!=null){
            return new ResponseEntity<AsignaturaDTO>(asignaturaDTO, HttpStatus.OK);
        }else{
            EntidadNoExisteException objNoExisteException = new EntidadNoExisteException("La asignatura con id " + id + " no existe en la base de datos");
            throw objNoExisteException;
        }
    }

    @Override
    @Transactional()
    public ResponseEntity<?> save(AsignaturaDTO prmAsignatura) {
    	
    	if(prmAsignatura.getListaCursos().size() < 1 || prmAsignatura.getListaDocentes().size() < 1) {
    		ReglaNegocioExcepcion objReglaNegocioExcepcion = new ReglaNegocioExcepcion("Al registrar una asignatura debe estar asociada mínimo a un curso y un docente");
            throw objReglaNegocioExcepcion;
        }
 
        if(prmAsignatura.getIdAsignatura()!=null){
            Optional<Asignatura> optional = this.servicioAccesoBaseDatos.findById(prmAsignatura.getIdAsignatura());
            if(optional.isPresent()){
                EntidadYaExisteException exception = new EntidadYaExisteException("Asignatura con id "+prmAsignatura.getIdAsignatura()+" ya existe en la BD");
                throw exception;
            }
        }
        
        Asignatura objAsignatura = this.modelMapperB.map(prmAsignatura, Asignatura.class);
        for (int i=0;i<objAsignatura.getListaCursos().size();i++) {
            if(objAsignatura.getListaCursos().get(i).getIdCurso()!=null){
                Optional<Curso> obj=this.servicioADCurso.findById(objAsignatura.getListaCursos().get(i).getIdCurso());
                if(obj.isPresent()){
                    Curso curso=obj.get();
                    curso.setObjAsignatura(objAsignatura);
                    objAsignatura.getListaCursos().remove(i);
                    objAsignatura.getListaCursos().add(curso);
                }else{
                    objAsignatura.getListaCursos().get(i).setObjAsignatura(objAsignatura);
                }
            }else{
                objAsignatura.getListaCursos().get(i).setObjAsignatura(objAsignatura);
            }
        }
         for(int i=0;i<objAsignatura.getListaDocentes().size();i++){
            if(objAsignatura.getListaDocentes().get(i).getIdPersona()!=null){
                Optional<Docente> obj = this.servicioADDocente.findById(objAsignatura.getListaDocentes().get(i).getIdPersona());
                if(obj.isPresent()){
                    Docente docente=obj.get();
                    objAsignatura.getListaDocentes().remove(i);
                    objAsignatura.getListaDocentes().add(i, docente);        
                }
            }
            
        }
        Asignatura objAsignaturaRta = this.servicioAccesoBaseDatos.save(objAsignatura);
        
        AsignaturaDTO objAsignaturaDTO = this.modelMapperB.map(objAsignaturaRta, AsignaturaDTO.class);
        
        if(objAsignaturaDTO!=null){
            return new ResponseEntity<AsignaturaDTO>(objAsignaturaDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Error al almacenar la asignatura", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* 
    @Override
    public AsignaturaDTO findByIdPH(Integer id) {
        Optional<Asignatura> optional = this.servicioAccesoBaseDatos.findById(id);

        Asignatura asignatura = optional.get();
        AsignaturaDTO asignaturaDTO = this.modelMapperH.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;

    }
    */

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> buscarPorNombre(String nombre) {
        
        List<Asignatura> asignaturas = this.servicioAccesoBaseDatos.findByNombreIgnoreCaseContainingOrderByNombreAsc(nombre);
        if (!asignaturas.isEmpty()) {
            List<AsignaturaDTO>asinaturasDTO = this.modelMapperB.map(asignaturas, new TypeToken<List<AsignaturaDTO>>() {}.getType());    
            return new ResponseEntity<List<AsignaturaDTO>>(asinaturasDTO,HttpStatus.OK);

        }else{
            NoContentException objNoContentListException = new NoContentException("No se encontraron asignaturas con el nombre " + nombre);
            throw objNoContentListException;
        }
        
    }

    @Override
    @Transactional
    public ResponseEntity<List<AsignaturaDTO>> findAll(){
        Iterable<Asignatura> obj=this.servicioAccesoBaseDatos.findAll();
        List<AsignaturaDTO> rta=this.modelMapperAsig.map(obj, new TypeToken<List<AsignaturaDTO>>(){}.getType());   
        return new ResponseEntity<List<AsignaturaDTO>>(rta, HttpStatus.OK);
    }

}

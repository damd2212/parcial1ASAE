package co.edu.unicauca.asae.parcial1.services.services.cursoServices;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.models.Curso;
import co.edu.unicauca.asae.parcial1.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.parcial1.repositories.CursoRepository;
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
    public CursoDTO save(CursoDTO prmCurso, int id_asignatura) {
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
            System.out.println("Error al almacenar el curso");
        }
        return objCursoDTO;
    }


    @Override
    @Transactional
    public CursoDTO findById(String prmId){
        Optional<Curso> objCurso=this.servicioAccesoBaseDatos.findById(prmId);
        CursoDTO objCursoDTO=null;
        if(objCurso.isPresent()){
            objCursoDTO=this.modelMapper.map(objCurso.get(),CursoDTO.class);
        }
        return objCursoDTO;
    }
}

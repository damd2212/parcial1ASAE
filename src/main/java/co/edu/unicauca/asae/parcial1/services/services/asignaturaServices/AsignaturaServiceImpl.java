package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.ObjDoubleConsumer;

import javax.print.Doc;
import javax.validation.constraints.Null;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.models.Curso;
import co.edu.unicauca.asae.parcial1.models.Docente;
import co.edu.unicauca.asae.parcial1.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.parcial1.repositories.CursoRepository;
import co.edu.unicauca.asae.parcial1.repositories.DocenteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;
import co.edu.unicauca.asae.parcial1.services.services.cursoServices.CursoServiceImpl;
import co.edu.unicauca.asae.parcial1.services.services.cursoServices.ICursoService;
import co.edu.unicauca.asae.parcial1.services.services.docenteServices.DocenteServiceImpl;
import co.edu.unicauca.asae.parcial1.services.services.docenteServices.IDocenteService;

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
    @Override
    @Transactional(readOnly = true)
    public AsignaturaDTO findById(Integer id) {
        Optional<Asignatura> optional = this.servicioAccesoBaseDatos.findById(id);
        Asignatura asignatura = optional.get();
        AsignaturaDTO asignaturaDTO = this.modelMapper.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;
    }

    @Override
    @Transactional()
    public AsignaturaDTO save(AsignaturaDTO prmAsignatura) {
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
                    if(docente.getListaAsignaturas()!=null){
                        docente.getListaAsignaturas().add(objAsignatura);
                    }else{
                        docente.setListaAsignaturas(new ArrayList<>(Arrays.asList(objAsignatura)));
                    }
                    objAsignatura.getListaDocentes().remove(i);
                    objAsignatura.getListaDocentes().add(i, docente);
                }else{
                    objAsignatura.getListaDocentes().get(i).setListaAsignaturas(new ArrayList<>(Arrays.asList(objAsignatura)));
                }
            }
            
        }
        Asignatura objAsignaturaRta = this.servicioAccesoBaseDatos.save(objAsignatura);
        
        AsignaturaDTO objAsignaturaDTO = this.modelMapperB.map(objAsignaturaRta, AsignaturaDTO.class);
        return objAsignaturaDTO;
    }

    @Override
    public AsignaturaDTO findByIdPH(Integer id) {
        Optional<Asignatura> optional = this.servicioAccesoBaseDatos.findById(id);

        Asignatura asignatura = optional.get();
        AsignaturaDTO asignaturaDTO = this.modelMapperH.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;

    }

}

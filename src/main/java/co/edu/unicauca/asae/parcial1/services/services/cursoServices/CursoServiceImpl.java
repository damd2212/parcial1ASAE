package co.edu.unicauca.asae.parcial1.services.services.cursoServices;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.parcial1.models.Curso;
import co.edu.unicauca.asae.parcial1.repositories.CursoRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;

@Service
public class CursoServiceImpl implements ICursoService{

    @Autowired
	private CursoRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

    /* 
     * Método que permite guardar un curso en la base de datos
     * prmCurso = objeto de tipo cursoDTO
     * Return = objeto de tipo cursoDTO
     */
    @Override
    @Transactional()
    public CursoDTO save(CursoDTO prmCurso) {
        Curso objCurso=this.modelMapper.map(prmCurso, Curso.class);
        Curso objCursoRespuesta=this.servicioAccesoBaseDatos.save(objCurso);
        CursoDTO objCursoDTO=this.modelMapper.map(objCursoRespuesta, CursoDTO.class);
        return objCursoDTO;
    }
}

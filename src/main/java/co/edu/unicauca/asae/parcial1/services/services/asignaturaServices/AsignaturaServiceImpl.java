package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignturaService {

    @Autowired
    private AsignaturaRepository servicioAccesoBaseDatos;

    @Autowired
    @Qualifier("mapperpuntoi")
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("mapperpuntoh")
    private ModelMapper modelMapperH;

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
        Asignatura objAsignatura = this.modelMapper.map(prmAsignatura, Asignatura.class);
        objAsignatura.getListaCursos().forEach(objCurso -> objCurso.setObjAsignatura(objAsignatura));
        objAsignatura.getListaDocentes()
                .forEach(objDocente -> objDocente.setListaAsignaturas(new ArrayList<>(Arrays.asList(objAsignatura))));

        Asignatura objAsignaturaRta = this.servicioAccesoBaseDatos.save(objAsignatura);
        AsignaturaDTO objAsignaturaDTO = this.modelMapper.map(objAsignaturaRta, AsignaturaDTO.class);
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

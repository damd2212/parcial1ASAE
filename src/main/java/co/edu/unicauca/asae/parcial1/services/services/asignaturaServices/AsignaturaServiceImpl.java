package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.parcial1.models.Asignatura;
import co.edu.unicauca.asae.parcial1.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignturaService{

    @Autowired
	private AsignaturaRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public AsignaturaDTO findById(Integer id) {
        Optional<Asignatura> optional = this.servicioAccesoBaseDatos.findById(id);
        Asignatura asignatura = optional.get();
        AsignaturaDTO asignaturaDTO = this.modelMapper.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;
    }
    
}

package co.edu.unicauca.asae.parcial1.services.services.estudianteServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.parcial1.models.Direccion;
import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.models.Telefono;
import co.edu.unicauca.asae.parcial1.repositories.EstudianteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.TelefonoDTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{


    @Autowired
    private EstudianteRepository servicioAccesoBDestudiante;

    @Autowired
    private ModelMapper estudainteModelMapper;

    @Override
    public EstudianteDTO findById(Integer idEstudainte) {

        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(idEstudainte); 
        if (optional.isPresent()) {
            Estudiante estudiante = optional.get();
            System.out.println("Antes de consultar los datos");
            EstudianteDTO estudianteDTO = this.estudainteModelMapper.map(estudiante,EstudianteDTO.class);
            return estudianteDTO;
        }else{
            System.out.println("Estudiante no encontrado");
        }
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public EstudianteDTO update(Integer id, EstudianteDTO estudiante) {
        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(id);
        EstudianteDTO estudianteDTOActualizado = null;
        
        if(optional.isPresent()){
            Estudiante objEstudianteAlmacenado = optional.get();
            objEstudianteAlmacenado.setIdPersona(estudiante.getIdPersona());
            objEstudianteAlmacenado.setNombres(estudiante.getNombres());
            objEstudianteAlmacenado.setApellidos(estudiante.getApellidos());
            objEstudianteAlmacenado.setNoIdentificacion(estudiante.getNoIdentificacion());
            objEstudianteAlmacenado.setFechaIngreso(estudiante.getFechaIngreso());
            objEstudianteAlmacenado.setTipoIdentificacion(estudiante.getTipoIdentificacion());
            Direccion objDireccionAlmacenada = objEstudianteAlmacenado.getObjDireccion();
            objDireccionAlmacenada.setIdEstudiante(estudiante.getObjDireccion().getIdEstudiante());
            objDireccionAlmacenada.setCiudad(estudiante.getObjDireccion().getCiudad());
            objDireccionAlmacenada.setDireccionResidencia(estudiante.getObjDireccion().getDireccionResidencia());
            objDireccionAlmacenada.setPais(estudiante.getObjDireccion().getPais());
            List<TelefonoDTO> listaTelefonosNuevos = estudiante.getListaTelefonos();
            List<Telefono> listaTelefonosAlmacenados = objEstudianteAlmacenado.getListaTelefonos();
            Integer index = 0;
            for (TelefonoDTO telefono : listaTelefonosNuevos) {
                listaTelefonosAlmacenados.get(index).setIdTelefono(telefono.getIdTelefono());
                listaTelefonosAlmacenados.get(index).setNumero(telefono.getNumero());
                listaTelefonosAlmacenados.get(index).setTipo(telefono.getTipo());
                index++;
            }
            Estudiante estudianteActualizado = this.servicioAccesoBDestudiante.save(objEstudianteAlmacenado);
            estudianteDTOActualizado= this.estudainteModelMapper.map(estudianteActualizado,EstudianteDTO.class);
        }

        return estudianteDTOActualizado;
    }
    
}

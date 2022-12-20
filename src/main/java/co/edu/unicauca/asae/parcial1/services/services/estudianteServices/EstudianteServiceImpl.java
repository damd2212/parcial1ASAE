package co.edu.unicauca.asae.parcial1.services.services.estudianteServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.parcial1.exceptionControllers.exceptions.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.parcial1.models.Direccion;
import co.edu.unicauca.asae.parcial1.models.Estudiante;
import co.edu.unicauca.asae.parcial1.models.Telefono;
import co.edu.unicauca.asae.parcial1.repositories.EstudianteRepository;
import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;
import co.edu.unicauca.asae.parcial1.services.DTO.TelefonoDTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository servicioAccesoBDestudiante;

    @Autowired
    @Qualifier("mapperpuntog")
    private ModelMapper estudianteModelMapper;

    @Autowired
    @Qualifier("mapperbase")
    private ModelMapper estudianteModelMapperpuntof;

    @Override
    public EstudianteDTO save(EstudianteDTO estudiante) {
        
        Estudiante estudianteEntity = this.estudianteModelMapperpuntof.map(estudiante, Estudiante.class);
        estudianteEntity.getListaTelefonos().forEach(telefono -> telefono.setObjEstudiante(estudianteEntity));
        estudianteEntity.getObjDireccion().setObjEstudiante(estudianteEntity);

        Estudiante objEstudianteCreado = this.servicioAccesoBDestudiante.save(estudianteEntity);
        EstudianteDTO estudianteDTO = this.estudianteModelMapperpuntof.map(objEstudianteCreado, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO findById(Integer idEstudainte) {

        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(idEstudainte);

        Estudiante estudiante = optional.get();
        System.out.println("Antes de consultar los datos");
        EstudianteDTO estudianteDTO = this.estudianteModelMapperpuntof.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;

    }

    @Override
    @Transactional(readOnly = false)
    public EstudianteDTO update(Integer id, EstudianteDTO estudiante) {
        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(id);
        EstudianteDTO estudianteDTOActualizado = null;

        if (optional.isPresent()) {
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
                index = existe(listaTelefonosAlmacenados, telefono.getIdTelefono());
                if (index!=-1) {
                    listaTelefonosAlmacenados.get(index).setIdTelefono(telefono.getIdTelefono());
                    listaTelefonosAlmacenados.get(index).setNumero(telefono.getNumero());
                    listaTelefonosAlmacenados.get(index).setTipo(telefono.getTipo());
                }
            }
            Estudiante estudianteActualizado = this.servicioAccesoBDestudiante.save(objEstudianteAlmacenado);
            estudianteDTOActualizado = this.estudianteModelMapperpuntof.map(estudianteActualizado, EstudianteDTO.class);
        }

        return estudianteDTOActualizado;
    }

    private Integer existe(List<Telefono> listTelefonosAlmacenados, Integer idTelefonoActualizado){
        Integer index = 0;
        for (Telefono telefono : listTelefonosAlmacenados) {
            if(telefono.getIdTelefono()==idTelefonoActualizado){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public EstudianteDTO findByIdG(Integer idEstudainte) {
        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(idEstudainte);

        Estudiante estudiante = optional.get();
        System.out.println("Antes de consultar los datos");
        EstudianteDTO estudianteDTO = this.estudianteModelMapper.map(estudiante, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean delete(Integer id) {
        boolean bandera = false;
        Optional<Estudiante> optional = this.servicioAccesoBDestudiante.findById(id);
        Estudiante objEstudiante = optional.get();
        if (objEstudiante != null) {
            this.servicioAccesoBDestudiante.delete(objEstudiante);
            bandera = true;
        }
        return bandera;
    }

    @Override
    public ResponseEntity<?> register(EstudianteDTO estudiante) {


        Estudiante objEstudiante = this.servicioAccesoBDestudiante.findEstudianteByIdAndTipo(estudiante.getNoIdentificacion(),estudiante.getTipoIdentificacion());
        System.out.println("--------------");
        System.out.println(objEstudiante);
        System.out.println("--------------");
        if (objEstudiante != null) {
            EntidadYaExisteException objException = new EntidadYaExisteException("Estudiante con identificacion: " + estudiante.getNoIdentificacion() + " de tipo " + estudiante.getTipoIdentificacion() +" ya existe en la base de datos");
            throw objException;
        }
        
        
        Estudiante estudianteEntity = this.estudianteModelMapperpuntof.map(estudiante, Estudiante.class);

        EstudianteDTO estudianteDTO = null;

        if (estudianteEntity.getObjDireccion() != null) {

            if (estudianteEntity.getListaTelefonos().size() >= 2) {

                estudianteEntity.getListaTelefonos().forEach(telefono -> telefono.setObjEstudiante(estudianteEntity));
                estudianteEntity.getObjDireccion().setObjEstudiante(estudianteEntity);

                Estudiante objEstudianteCreado = this.servicioAccesoBDestudiante.save(estudianteEntity);
                estudianteDTO = this.estudianteModelMapperpuntof.map(objEstudianteCreado, EstudianteDTO.class);
            }else{
                ReglaNegocioExcepcion objReglaNegocioExcepciontel = new ReglaNegocioExcepcion("Al registrar un estudiante debe tener como minimo dos telefonos");
                throw objReglaNegocioExcepciontel;
            }
            
        }else{
            ReglaNegocioExcepcion objReglaNegocioExcepcion = new ReglaNegocioExcepcion("Al registrar un estudiante la direccion no puede ser nula");
            throw objReglaNegocioExcepcion;
        }
        
        return new ResponseEntity<EstudianteDTO>(estudianteDTO, HttpStatus.CREATED);
    }

}

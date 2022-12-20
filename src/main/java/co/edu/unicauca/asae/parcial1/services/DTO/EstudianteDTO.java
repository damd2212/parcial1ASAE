package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstudianteDTO extends PersonaDTO{

    @PastOrPresent(message = "{estudiante.date.past}")
    private Date fechaIngreso;
    @Valid
    private DireccionDTO objDireccion;
    
    @Valid
    private List<TelefonoDTO> listaTelefonos;
    
    @Email(message = "{estudiante.correoElectronico.mask}")
    private String correoElectronico;

    public EstudianteDTO(){
        super();
    }
    
    public EstudianteDTO(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, Date fechaIngreso, DireccionDTO prmDireccion, List<TelefonoDTO> listaTelefonos, String prmCorreoElectronico){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.fechaIngreso = fechaIngreso;
        this.objDireccion = prmDireccion;
        this.listaTelefonos = listaTelefonos;
        this.correoElectronico = prmCorreoElectronico;
    }
}

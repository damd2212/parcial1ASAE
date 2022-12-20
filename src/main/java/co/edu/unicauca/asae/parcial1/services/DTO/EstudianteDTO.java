package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstudianteDTO extends PersonaDTO{

    @PastOrPresent(message = "{estudiante.fecha.pasado}")
    private Date fechaIngreso;


    //@NotNull(message = "{direccion.empty}")
    private DireccionDTO objDireccion;
    
    //@Size(min = 2,message = "{telefonos.size}")
    private List<TelefonoDTO> listaTelefonos;

    public EstudianteDTO(){
        super();
    }
    
    public EstudianteDTO(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, Date fechaIngreso, DireccionDTO prmDireccion, List<TelefonoDTO> listaTelefonos){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.fechaIngreso = fechaIngreso;
        this.objDireccion = prmDireccion;
        this.listaTelefonos = listaTelefonos;
    }
}

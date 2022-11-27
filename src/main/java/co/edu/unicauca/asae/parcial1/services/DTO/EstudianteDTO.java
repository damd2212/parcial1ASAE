package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstudianteDTO extends PersonaDTO{
    private Date fechaIngreso;

    private DireccionDTO objDireccion;
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

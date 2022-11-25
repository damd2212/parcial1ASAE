package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstudianteDTO extends PersonaDTO{
    private Date fechaIngreso;

    public EstudianteDTO(){
        super();
    }
    
    public EstudianteDTO(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, Date fechaIngreso){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.fechaIngreso = fechaIngreso;
    }
}

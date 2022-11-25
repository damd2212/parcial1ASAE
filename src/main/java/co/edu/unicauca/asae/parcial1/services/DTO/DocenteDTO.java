package co.edu.unicauca.asae.parcial1.services.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DocenteDTO extends PersonaDTO {
    private String universidad;
    private String tipoDocente;
    private float salario;


    public DocenteDTO(){
        super();
    }
    
    public DocenteDTO(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, String universidad, String tipoDocente, float salario){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
    }
}

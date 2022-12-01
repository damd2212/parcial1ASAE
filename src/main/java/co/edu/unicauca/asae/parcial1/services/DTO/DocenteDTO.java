package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DocenteDTO extends PersonaDTO {
    
    private String universidad;
    private String tipoDocente;
    private float salario;

    
    private List<AsignaturaDTO> listaAsignaturas;


    public DocenteDTO(){
        super();
    }
    
    public DocenteDTO(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, String universidad, String tipoDocente, float salario, List<AsignaturaDTO> listaAsignaturas){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
        this.listaAsignaturas = listaAsignaturas;
    }
}

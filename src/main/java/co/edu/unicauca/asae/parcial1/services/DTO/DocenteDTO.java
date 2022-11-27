package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DocenteDTO extends PersonaDTO {
    
    @NotBlank(message = "{docente.universidad.empty}")
    private String universidad;
    @NotBlank(message = "{docente.tipoDocente.empty}")
    private String tipoDocente;
    @PositiveOrZero(message = "{docente.salario.negative}")
    private float salario;

    private List<AsignaturaDTO> listaAsignatura;


    public DocenteDTO(){
        super();
    }
    
    public DocenteDTO(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, String universidad, String tipoDocente, float salario, List<AsignaturaDTO> listaAsignaturas){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
        this.listaAsignatura = listaAsignaturas;
    }
}

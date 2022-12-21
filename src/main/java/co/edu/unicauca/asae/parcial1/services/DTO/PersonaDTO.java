package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonaDTO {
    private Integer idPersona;
    
    @NotEmpty(message = "{persona.noIdentificacion.empty}")
    private String noIdentificacion;
    
    @NotEmpty(message = "{persona.tipoIdentificacion.empty}")
    private String tipoIdentificacion;
    
    @NotEmpty(message = "{estudiante.name.empty}")
	@Size(min = 3,max = 50,message = "{persona.nombre.size}")
    private String nombres;
    
    @NotEmpty(message = "{estudiante.lastname.empty}")
    @Size(min = 3,max = 50,message = "{persona.apellido.size}")
    private String apellidos;
   
}

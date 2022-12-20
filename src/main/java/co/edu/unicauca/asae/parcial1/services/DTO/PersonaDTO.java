package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonaDTO {
    private Integer idPersona;
    private String noIdentificacion;
    private String tipoIdentificacion;
    @NotNull(message = "{estudiante.name.empty}")
	@Size(min = 5, max = 50, message = "{estudiante.name.length}")
    private String nombres;
    @NotNull(message = "{estudiante.lastname.empty}")
	@Size(min = 3, max = 50, message = "{estudiante.lastname.length}")
    private String apellidos;
}

package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotBlank;
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

    @Size(min = 3,max = 50,message = "{persona.nombre.size}")
    private String nombres;

    @Size(min = 3,max = 50,message = "{persona.apellido.size}")
    private String apellidos;
}

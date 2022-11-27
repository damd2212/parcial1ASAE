package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonaDTO {
    private Integer idPersona;
    @NotBlank(message = "{persona.noIdentificacion.empty}")
    private String noIdentificacion;
    @NotBlank(message = "{persona.tipoIdentificacion.empty}")
    private String tipoIdentificacion;
    @NotBlank(message = "{persona.nombres.empty}")
    private String nombres;
    @NotBlank(message = "{persona.apelidos.empty}")
    private String apellidos;
}

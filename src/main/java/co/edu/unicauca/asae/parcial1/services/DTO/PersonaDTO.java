package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonaDTO {
    private Integer idPersona;
    @NotNull(message = "{persona.noIdentificacion.empty}")
    private String noIdentificacion;
    @NotNull(message = "{persona.tipoIdentificacion.empty}")
    private String tipoIdentificacion;
    @NotNull(message = "{persona.nombres.empty}")
    private String nombres;
    @NotNull(message = "{persona.apellidos.empty}")
    private String apellidos;
}

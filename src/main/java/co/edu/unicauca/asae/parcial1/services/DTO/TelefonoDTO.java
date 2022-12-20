package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TelefonoDTO {
    private Integer idTelefono;
    @NotNull(message = "{telefono.tipo.empty}")
    private String tipo;
    @NotNull(message = "{telefono.numero.empty}")
    private String numero;
}

package co.edu.unicauca.asae.parcial1.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TelefonoDTO {
    private Integer idTelefono;
    private String tipo;
    private String numero;
}

package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


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
    @Size(message = "{telefono.numero.size}", min = 5, max = 20)
    @Pattern(message = "{telefono.numero.pattern}", regexp = "^8.*$")
    private String numero;
}

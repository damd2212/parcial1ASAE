package co.edu.unicauca.asae.parcial1.services.DTO;

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
    
    private String tipo;
    
    @Size(message = "{telefono.numero.size}", min = 5, max = 20)
    @Pattern(message = "{telefono.numero.pattern}", regexp = "^8.*$")
    private String numero;
}

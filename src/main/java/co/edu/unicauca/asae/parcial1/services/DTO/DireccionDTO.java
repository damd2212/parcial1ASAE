package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DireccionDTO {
    
	private Integer idEstudiante;

    @Size(min=5,max = 25,message = "{direccion.direccionResidencia.size}")
    private String direccionResidencia;
    
    @Size(min=4, max = 50, message ="{direccion.ciudad.size}")
    private String ciudad;
    
    @Size(min=4, max = 50, message ="{direccion.pais.size}")
    private String pais;
}

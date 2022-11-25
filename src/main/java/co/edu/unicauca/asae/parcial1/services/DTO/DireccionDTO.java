package co.edu.unicauca.asae.parcial1.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DireccionDTO {
    
	private Integer idEstudiante;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
}

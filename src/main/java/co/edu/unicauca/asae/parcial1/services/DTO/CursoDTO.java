package co.edu.unicauca.asae.parcial1.services.DTO;


import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CursoDTO {
    private String idCurso;
    @Size(min=5,max = 25,message = "{curso.nombre.size}")
    private String nombre;
    private Integer periodo;
}

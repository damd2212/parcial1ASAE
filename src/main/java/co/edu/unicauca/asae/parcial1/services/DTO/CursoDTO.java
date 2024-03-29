package co.edu.unicauca.asae.parcial1.services.DTO;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CursoDTO {
    @NotEmpty(message = "{curso.idCurso.empty}")
    private String idCurso;
    @NotNull(message = "{curso.nombre.vacio}")
    @Size(min=5,max = 25,message = "{curso.nombre.size}")
    private String nombre;
    @NotNull(message = "{curso.periodo.vacio}")
    @Min(value=1,message = "{curso.periodo.size}")
    @Max(value=2,message = "{curso.periodo.size}")
    private Integer periodo;
    
    private AsignaturaDTO objAsignatura;
}

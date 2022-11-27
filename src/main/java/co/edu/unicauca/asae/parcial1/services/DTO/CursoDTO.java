package co.edu.unicauca.asae.parcial1.services.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CursoDTO {
    private String idCurso;
    @NotBlank(message = "{curso.nombre.empty}")
    private String nombre;
    @Positive(message = "{curso.periodo.negative}")
    private Integer periodo;
}

package co.edu.unicauca.asae.parcial1.services.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CursoDTO {
    private String idCurso;
    private String nombre;
    private Integer periodo;
}

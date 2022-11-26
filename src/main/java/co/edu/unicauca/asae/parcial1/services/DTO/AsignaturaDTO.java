package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class AsignaturaDTO {
    private Integer idAsignatura;
    private String nombre;

    private List<DocenteDTO> listaDocentes;
    private List<CursoDTO> listaCursos;

}

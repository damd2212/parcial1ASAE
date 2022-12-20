package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.List;

import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class AsignaturaDTO {

    private Integer idAsignatura;

    @Size(min=5,max = 25,message = "{asignatura.nombre.size}")
    private String nombre;

    @Size(min = 2,message = "{asignatura.listaDocentes.size}")    
    private List<DocenteDTO> listaDocentes;

    @Size(min=1,message = "{asignatura.listaCursos.size}")
    private List<CursoDTO> listaCursos;

}

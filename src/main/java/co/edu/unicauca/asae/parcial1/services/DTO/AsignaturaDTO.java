package co.edu.unicauca.asae.parcial1.services.DTO;

import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class AsignaturaDTO {

    private Integer idAsignatura;
    //Peguntar las restrucciones par el nombre, min y max de caracteres

    private String nombre;
    @Size(min = 2,message = "{asignatura.listaDocentes.size}")
    @JsonBackReference
    private List<DocenteDTO> listaDocentes;
    @Size(min=1,message = "{asignatura.listaCursos.size}")
    private List<CursoDTO> listaCursos;

}

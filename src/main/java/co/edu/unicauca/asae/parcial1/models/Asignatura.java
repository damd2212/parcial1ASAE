package co.edu.unicauca.asae.parcial1.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Asignaturas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Asignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignatura;

    @Column(nullable = false,length = 30)
    private String nombre;

    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "Docentes_Asignaturas",
               joinColumns = @JoinColumn(name = "idAsignatura"),
               inverseJoinColumns = @JoinColumn(name = "idDocente")
    )
    private List<Docente> listaDocentes;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER, mappedBy = "objAsignatura")
    private List<Curso> listaCursos;

}

package co.edu.unicauca.asae.parcial1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cursos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Curso {

    @Id
    @Column(length = 30)
    private String idCurso;

    @Column(nullable = false,length = 30)
    private String nombre;

    @Column(nullable = false)
    private Integer periodo;

    @ManyToOne
    @JoinColumn(name = "idAsignatura",nullable = true)
    private Asignatura objAsignatura;
}

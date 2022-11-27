package co.edu.unicauca.asae.parcial1.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Docente extends Persona{
    
    @Column(nullable = false,length = 50)
    private String universidad;

    @Column(nullable = false,length = 50)
    private String tipoDocente;

    @Column(nullable = false)
    private float salario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Docentes_Asignaturas",
               joinColumns = @JoinColumn(name = "idDocente"),
               inverseJoinColumns = @JoinColumn(name = "idAsignatura")
    )
    private List<Asignatura> listaAsignaturas;

    public Docente(){
        super();
    }
    
    public Docente(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, String universidad, String tipoDocente, float salario, List<Asignatura> listAsignatura){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
        this.listaAsignaturas = listAsignatura;
    }

}

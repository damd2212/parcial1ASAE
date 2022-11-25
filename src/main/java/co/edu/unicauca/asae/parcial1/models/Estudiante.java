package co.edu.unicauca.asae.parcial1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudiante extends Persona{
    
    @Column(nullable = false)
    private Date fechaIngreso;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH},fetch = FetchType.EAGER, mappedBy = "objEstudiante")
    private List<Telefono> listaTelefonos;

	@OneToOne(optional = false, cascade = { CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "objEstudiante")
    private Direccion objDireccion;


    public Estudiante(){
        super();
    }
    
    public Estudiante(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, Date fechaIngreso){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.fechaIngreso = fechaIngreso;
    }

}

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
    //Para el punto f es Eager
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH},fetch = FetchType.EAGER, mappedBy = "objEstudiante")
    private List<Telefono> listaTelefonos;
    ////Para el punto f es Eager
	@OneToOne(optional = false, cascade = { CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "objEstudiante")
    private Direccion objDireccion;

    @Column(nullable = false)
    private String correoElectronico;

    public Estudiante(){
        super();
    }
    
    public Estudiante(Integer idPersona, String noIdentificacion, String tipoIdentificacion,String nombres, String apellidos, Date fechaIngreso, List<Telefono> listaTelefonos, Direccion prmDireccion,String correoElectronico){
        super(idPersona,noIdentificacion,tipoIdentificacion,nombres,apellidos);
        this.fechaIngreso = fechaIngreso;
        this.listaTelefonos = listaTelefonos;
        this.objDireccion = prmDireccion;
        this.correoElectronico = correoElectronico;
    }

}

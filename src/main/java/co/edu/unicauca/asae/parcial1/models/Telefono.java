package co.edu.unicauca.asae.parcial1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "telefonos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefono;

    @Column(nullable = false,length = 50)
    private String tipo;

    @Column(nullable = false,length = 50)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idEstudiante",nullable = false)
    private Estudiante objEstudiante;

}

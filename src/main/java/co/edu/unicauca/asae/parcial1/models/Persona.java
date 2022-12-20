package co.edu.unicauca.asae.parcial1.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(nullable = false,length = 50)
    private String noIdentificacion;

    @Column(nullable = false,length = 50)
    private String tipoIdentificacion;

    @Column(nullable = false,length = 50)
    private String nombres;

    @Column(nullable = false,length = 50)
    private String apellidos;
}

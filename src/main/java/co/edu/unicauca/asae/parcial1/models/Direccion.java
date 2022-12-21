package co.edu.unicauca.asae.parcial1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Direcciones")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Direccion {
    
    @Id
	private Integer idEstudiante;

    
    @Column(nullable = false)
    private String direccionResidencia;

    @Column(nullable = false,length = 30)
    private String ciudad;

    @Column(nullable = false,length = 30)
    private String pais;

    @OneToOne(optional = false)
	@MapsId
	@JoinColumn(name = "idEstudiante", nullable = false)
	private Estudiante objEstudiante;
}

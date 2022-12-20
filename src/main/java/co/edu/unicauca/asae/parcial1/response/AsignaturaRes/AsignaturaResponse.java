package co.edu.unicauca.asae.parcial1.response.AsignaturaRes;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;
import lombok.Data;

@Data
public class AsignaturaResponse {
    
    List<AsignaturaDTO> asignaturas;

    public AsignaturaResponse(){
        this.asignaturas = new ArrayList<AsignaturaDTO>();
    }


}

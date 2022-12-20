package co.edu.unicauca.asae.parcial1.response.AsignaturaRes;

import co.edu.unicauca.asae.parcial1.response.ResponseRest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsignaturaResponseRest extends ResponseRest{
    private AsignaturaResponse asignaturaResponse;

    public AsignaturaResponseRest(){
        this.asignaturaResponse = new AsignaturaResponse();
    }
}

package co.edu.unicauca.asae.parcial1.services.services.cursoServices;

import co.edu.unicauca.asae.parcial1.services.DTO.CursoDTO;

public interface ICursoService {
    public CursoDTO save(CursoDTO prmCurso, int id_asignatura);
    public CursoDTO findById(String prmId);
}

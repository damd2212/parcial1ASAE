package co.edu.unicauca.asae.parcial1.services.services.asignaturaServices;

import co.edu.unicauca.asae.parcial1.services.DTO.AsignaturaDTO;

public interface IAsignturaService {
    public AsignaturaDTO save(AsignaturaDTO prmAsignatura);
    public AsignaturaDTO findById(Integer id);
}

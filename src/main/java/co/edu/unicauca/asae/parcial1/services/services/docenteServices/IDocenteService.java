package co.edu.unicauca.asae.parcial1.services.services.docenteServices;

import java.util.List;

import co.edu.unicauca.asae.parcial1.services.DTO.DocenteDTO;

public interface IDocenteService {
    public DocenteDTO save(DocenteDTO prmDocente);
    public DocenteDTO findById(int prmId);
    public List<DocenteDTO> findAll();
}

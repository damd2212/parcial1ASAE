package co.edu.unicauca.asae.parcial1.services.services.estudianteServices;


import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;

public interface IEstudianteService {
    public EstudianteDTO findById(Integer idEstudainte);

    public EstudianteDTO update(Integer id, EstudianteDTO estudiante);
}

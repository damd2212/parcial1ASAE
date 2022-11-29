package co.edu.unicauca.asae.parcial1.services.services.estudianteServices;


import co.edu.unicauca.asae.parcial1.services.DTO.EstudianteDTO;

public interface IEstudianteService {
	
	public EstudianteDTO save(EstudianteDTO estudiante);
	
    public EstudianteDTO findById(Integer idEstudainte);

    public EstudianteDTO findByIdG(Integer idEstudainte);

    public EstudianteDTO update(Integer id, EstudianteDTO estudiante);
    
    public Boolean delete(Integer id);
}

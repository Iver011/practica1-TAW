package com.universidad.service.impl;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.repository.EstudianteRepository;
import com.universidad.service.IEstudianteService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @PostConstruct
    public void init() {
        estudianteRepository.init();
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertToDTO(estudiante));
        }
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id);

        if (estudiante == null) {
            return null; // Devuelve null si no se encuentra el estudiante
        }

        return convertToDTO(estudiante);
    }
    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
    Estudiante estudiante = convertToEntity(estudianteDTO); 
    Estudiante estudianteGuardado = estudianteRepository.save(estudiante); 
    return convertToDTO(estudianteGuardado); 
}   
@Override
public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
    Estudiante estudianteExistente = estudianteRepository.findById(id); 

    if (estudianteExistente == null) {
        return null; 
    }

    estudianteExistente.setNombre(estudianteDTO.getNombre());
    estudianteExistente.setApellido(estudianteDTO.getApellido());
    estudianteExistente.setEmail(estudianteDTO.getEmail());
    estudianteExistente.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
    estudianteExistente.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());

    Estudiante estudianteActualizado = estudianteRepository.save(estudianteExistente); 
    return convertToDTO(estudianteActualizado); 
}
@Override
public void delete(Long id) {
    
    Estudiante estudiante = estudianteRepository.findById(id); 
    if (estudiante != null) {
        
        estudianteRepository.deleteById(id);
    } else {
        
        throw new RuntimeException("Estudiante no encontrado con ID: " + id);
    }
}


 /* 
    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        Estudiante estudiante = estudianteRepository.findById(id);

        if (estudiante == null) {
            return null; // Devuelve null si no existe el estudiante
        }

        // Actualizamos los datos
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setApellido(estudianteDTO.getApellido());
        estudiante.setEmail(estudianteDTO.getEmail());
        estudiante.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
        estudiante.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());

        estudianteRepository.save(estudiante); // Guardamos los cambios
        return convertToDTO(estudiante);
    }

    @Override
    public boolean eliminarEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id);

        if (estudiante == null) {
            return false; // Retorna falso si el estudiante no existe
        }

        estudianteRepository.deleteById(id);
        return true; // Retorna verdadero si se eliminó correctamente
    }
*/
    // Método auxiliar para convertir entidad a DTO
    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email(estudiante.getEmail())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .numeroInscripcion(estudiante.getNumeroInscripcion())
                .build();
    }

    // Método auxiliar para convertir DTO a entidad
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .build();
    }
}

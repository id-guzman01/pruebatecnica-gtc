package com.prueba.tecnica.Persistence.Repository;

import com.prueba.tecnica.Persistence.Entity.Estudiante;
import com.prueba.tecnica.Service.DTO.EstudianteDTO;

import java.util.List;

public interface IEstudianteRepository {

    public int createEstudiante(Estudiante estudiante);

    public EstudianteDTO isEstudiante(int numeroDoc);

    public List<EstudianteDTO> findEstudiantes();

    public int updateEstudiante(int estudianteId, Estudiante estudiante);

    public int deleteEstudiante(int estudianteId);

}

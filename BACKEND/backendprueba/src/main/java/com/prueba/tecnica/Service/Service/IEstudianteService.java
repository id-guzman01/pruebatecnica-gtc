package com.prueba.tecnica.Service.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prueba.tecnica.Persistence.Entity.Estudiante;
import com.prueba.tecnica.Service.DTO.EstudianteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEstudianteService {

    public ResponseEntity<String> createEstudiante(EstudianteDTO estudianteDTO) throws JsonProcessingException;

    public List<EstudianteDTO> findEstudiantes();

    public ResponseEntity<String> updateEstudiante(int estudianteId, EstudianteDTO estudianteDTO) throws JsonProcessingException;

    public ResponseEntity<String> deleteEstudiante(int estudianteId) throws JsonProcessingException;

}

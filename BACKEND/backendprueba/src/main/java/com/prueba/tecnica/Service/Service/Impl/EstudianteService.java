package com.prueba.tecnica.Service.Service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prueba.tecnica.Exception.CustomException;
import com.prueba.tecnica.Mapper.EstudianteMapper;
import com.prueba.tecnica.Persistence.Entity.Estudiante;
import com.prueba.tecnica.Persistence.Repository.Impl.EstudianteRepository;
import com.prueba.tecnica.Service.DTO.EstudianteDTO;
import com.prueba.tecnica.Service.Service.IEstudianteService;
import com.prueba.tecnica.Util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ResponseJson responseJson;

    @Autowired
    private EstudianteMapper estudianteMapper;

    @Override
    public ResponseEntity<String> createEstudiante(EstudianteDTO estudianteDTO) throws JsonProcessingException {
        EstudianteDTO estudianteValidado = estudianteRepository.isEstudiante(estudianteDTO.getEstudianteNumerodoc());
        if (estudianteValidado != null) {
            throw new CustomException("El estudiante ya existe",400);
        }
        Estudiante estudiante = estudianteMapper.map(estudianteDTO);
        estudianteRepository.createEstudiante(estudiante);
        return new ResponseEntity<>(
                responseJson.respuesta("Estudiante registrado","201"),
                HttpStatus.CREATED);
    }

    @Override
    public List<EstudianteDTO> findEstudiantes() {
        return estudianteRepository.findEstudiantes();
    }

    @Override
    public ResponseEntity<String> updateEstudiante(int estudianteId, EstudianteDTO estudianteDTO) throws JsonProcessingException {
        EstudianteDTO estudianteValidado = estudianteRepository.isEstudiante(estudianteDTO.getEstudianteNumerodoc());
        if (estudianteValidado == null) {
            throw new CustomException("El estudiante no existe",400);
        }
        Estudiante estudiante = estudianteMapper.map(estudianteDTO);
        estudianteRepository.updateEstudiante(estudianteId, estudiante);
        return new ResponseEntity<>(
                responseJson.respuesta("Estudiante actualizado","200"),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteEstudiante(int estudianteId) throws JsonProcessingException {
        estudianteRepository.deleteEstudiante(estudianteId);
        return new ResponseEntity<>(
                responseJson.respuesta("Estudiante Eliminado","200"),
                HttpStatus.CREATED);
    }
}

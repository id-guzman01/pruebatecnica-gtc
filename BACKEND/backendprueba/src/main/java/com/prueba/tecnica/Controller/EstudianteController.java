package com.prueba.tecnica.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prueba.tecnica.Service.DTO.EstudianteDTO;
import com.prueba.tecnica.Service.Service.Impl.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estudiantes")
@Tag(
        name = "Estudiante Controller")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping(produces = "application/json")
    @Operation(summary = "Crear un estudiante")
    @ApiResponse(
            responseCode = "201",
            description = "Estado 201 con mensaje de estudiante creado"
    )
    public ResponseEntity<String> createEstudiante(@RequestBody EstudianteDTO estudianteDTO) throws JsonProcessingException {
        return estudianteService.createEstudiante(estudianteDTO);
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Mostrar la lista de estudiantes")
    @ApiResponse(
            responseCode = "200",
            description = "Estado 200 con la lista de estudiantes"
    )
    public List<EstudianteDTO> findEstudiantes() {
        return estudianteService.findEstudiantes();
    }

    @DeleteMapping(value = "/{estudianteId}", produces = "application/json")
    @Operation(summary = "Eliminar un estudiante")
    @ApiResponse(
            responseCode = "200",
            description = "Estado 200 con la eliminiación de un estudiante"
    )
    public ResponseEntity<String> deleteEstudiante(
            @PathVariable("estudianteId") int estudianteId) throws JsonProcessingException {
        return estudianteService.deleteEstudiante(estudianteId);
    }

    @PutMapping(value = "/{estudianteId}", produces = "application/json")
    @Operation(summary = "Actualizar un estudiante")
    @ApiResponse(
            responseCode = "200",
            description = "Estado 200 con la actualización de un estudiante"
    )
    public ResponseEntity<String> updateEstudiante(
            @PathVariable("estudianteID") int estudianteId,
            @RequestBody EstudianteDTO estudianteDTO) throws JsonProcessingException {
        return estudianteService.updateEstudiante(estudianteId,estudianteDTO);
    }

}

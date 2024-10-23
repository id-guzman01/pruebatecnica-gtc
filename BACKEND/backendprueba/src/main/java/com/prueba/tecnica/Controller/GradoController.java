package com.prueba.tecnica.Controller;

import com.prueba.tecnica.Service.DTO.GradoDTO;
import com.prueba.tecnica.Service.Service.Impl.GradoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grado")
@Tag(name = "Grado Controller")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listar grados")
    @ApiResponse(
            responseCode = "200",
            description = "Estado 200 con la lista de grados"
    )
    public List<GradoDTO> frindGrado() {
        return gradoService.frindGrado();
    }

}

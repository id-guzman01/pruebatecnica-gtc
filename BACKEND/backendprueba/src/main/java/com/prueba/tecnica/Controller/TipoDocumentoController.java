package com.prueba.tecnica.Controller;

import com.prueba.tecnica.Service.DTO.TipoDocumentoDTO;
import com.prueba.tecnica.Service.Service.Impl.TipoDocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoDocumento")
@Tag(name = "Tipo Documento Controller")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listar los tipos de documentos")
    @ApiResponse(
            responseCode = "200",
            description = "Estado 200 con la lista de tipos de documentos"
    )
    public List<TipoDocumentoDTO> findTipoDocumento() {
        return tipoDocumentoService.findTipoDocumento();
    }
}

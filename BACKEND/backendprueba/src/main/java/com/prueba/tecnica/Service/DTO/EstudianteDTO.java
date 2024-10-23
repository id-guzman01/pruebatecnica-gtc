package com.prueba.tecnica.Service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EstudianteDTO {

    private int estudianteId;
    private int tipodocumentoId;
    private int estudianteNumerodoc;
    private String estudianteNombres;
    private String estudianteApellidos;
    private String estudianteEdad;
    private Long estudianteCelular;
    private Long estudianteTelefono;
    private String estudianteEmail;
    private int gradoId;

    @JsonProperty(required = false)
    private GradoDTO gradoDTO;
    @JsonProperty(required = false)
    private TipoDocumentoDTO tipoDocumentoDTO;

}

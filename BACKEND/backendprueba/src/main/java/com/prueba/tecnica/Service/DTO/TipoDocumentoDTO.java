package com.prueba.tecnica.Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoDocumentoDTO {

    private int tipodocumentoId;
    private String tipodocumentoNombre;
    private String tipodocumentoAcronimo;

}

package com.prueba.tecnica.Persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {

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

}

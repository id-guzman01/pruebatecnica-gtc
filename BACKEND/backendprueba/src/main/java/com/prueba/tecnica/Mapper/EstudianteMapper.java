package com.prueba.tecnica.Mapper;

import com.prueba.tecnica.Persistence.Entity.Estudiante;
import com.prueba.tecnica.Service.DTO.EstudianteDTO;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper implements IMapper<EstudianteDTO, Estudiante> {
    @Override
    public Estudiante map(EstudianteDTO in) {
        Estudiante estudiante = new Estudiante();
        estudiante.setTipodocumentoId(in.getTipodocumentoId());
        estudiante.setEstudianteNumerodoc(in.getEstudianteNumerodoc());
        estudiante.setEstudianteNombres(in.getEstudianteNombres());
        estudiante.setEstudianteApellidos(in.getEstudianteApellidos());
        estudiante.setEstudianteEdad(in.getEstudianteEdad());
        estudiante.setEstudianteCelular(in.getEstudianteCelular());
        estudiante.setEstudianteTelefono(in.getEstudianteTelefono());
        estudiante.setEstudianteEmail(in.getEstudianteEmail());
        estudiante.setGradoId(in.getGradoId());
        return estudiante;
    }
}

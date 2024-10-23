package com.prueba.tecnica.Mapper;

import com.prueba.tecnica.Service.DTO.EstudianteDTO;
import com.prueba.tecnica.Service.DTO.GradoDTO;
import com.prueba.tecnica.Service.DTO.TipoDocumentoDTO;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EstudianteRowMapper implements RowMapper<EstudianteDTO> {

    @Override
    public EstudianteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EstudianteDTO estudiante = new EstudianteDTO();

        estudiante.setEstudianteId(rs.getInt("estudiante_id"));
        estudiante.setTipodocumentoId(rs.getInt("tipodocumento_id"));
        estudiante.setEstudianteNumerodoc(rs.getInt("estudiante_numerodoc"));
        estudiante.setEstudianteNombres(rs.getString("estudiante_nombres"));
        estudiante.setEstudianteApellidos(rs.getString("estudiante_apellidos"));
        estudiante.setEstudianteEdad(rs.getString("estudiante_edad"));
        estudiante.setEstudianteCelular(rs.getLong("estudiante_celular"));
        estudiante.setEstudianteTelefono(rs.getLong("estudiante_telefono"));
        estudiante.setEstudianteEmail(rs.getString("estudiante_email"));
        estudiante.setGradoId(rs.getInt("grado_id"));

        GradoDTO gradoDTO = new GradoDTO();
        gradoDTO.setGradoNombre(rs.getString("grado_nombre"));
        estudiante.setGradoDTO(gradoDTO);

        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setTipodocumentoNombre(rs.getString("tipodocumento_nombre"));
        tipoDocumentoDTO.setTipodocumentoAcronimo(rs.getString("tipodocumento_acronimo"));
        estudiante.setTipoDocumentoDTO(tipoDocumentoDTO);

        return estudiante;
    }
}

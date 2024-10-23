package com.prueba.tecnica.Persistence.Repository.Impl;

import com.prueba.tecnica.Exception.CustomException;
import com.prueba.tecnica.Mapper.EstudianteRowMapper;
import com.prueba.tecnica.Persistence.Entity.Estudiante;
import com.prueba.tecnica.Persistence.Repository.IEstudianteRepository;
import com.prueba.tecnica.Service.DTO.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class EstudianteRepository implements IEstudianteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createEstudiante(Estudiante estudiante) {
        try {
            String sql = "INSERT INTO ESTUDIANTE (" +
                    "tipodocumento_id, " +
                    "estudiante_numerodoc, " +
                    "estudiante_nombres, " +
                    "estudiante_apellidos, " +
                    "estudiante_edad, " +
                    "estudiante_celular, " +
                    "estudiante_telefono, " +
                    "estudiante_email, " +
                    "grado_id) VALUES (?,?,?,?,?,?,?,?,?)";
            return jdbcTemplate.update(sql,
                    estudiante.getTipodocumentoId(),
                    estudiante.getEstudianteNumerodoc(),
                    estudiante.getEstudianteNombres(),
                    estudiante.getEstudianteApellidos(),
                    estudiante.getEstudianteEdad(),
                    estudiante.getEstudianteCelular(),
                    estudiante.getEstudianteTelefono(),
                    estudiante.getEstudianteEmail(),
                    estudiante.getGradoId()
            );
        } catch (Exception e) {
            throw new CustomException("Inserción fallida", 400);
        }
    }

    @Override
    public EstudianteDTO isEstudiante(int estudianteNumerodoc) {
        String sql = "SELECT * FROM estudiante WHERE estudiante_numerodoc = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{estudianteNumerodoc}, new EstudianteRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<EstudianteDTO> findEstudiantes() {
        return jdbcTemplate.query("SELECT " +
                "    e.estudiante_id, " +
                "    e.tipodocumento_id, " +
                "    e.estudiante_numerodoc, " +
                "    e.estudiante_nombres, " +
                "    e.estudiante_apellidos, " +
                "    e.estudiante_edad, " +
                "    e.estudiante_celular, " +
                "    e.estudiante_telefono, " +
                "    e.estudiante_email, " +
                "    e.grado_id, " +
                "    g.grado_nombre, " +
                "    td.tipodocumento_nombre, " +
                "    td.tipodocumento_acronimo " +
                "FROM " +
                "    ESTUDIANTE e " +
                "    JOIN GRADO g ON e.grado_id = g.grado_id " +
                "    JOIN TIPODOCUMENTO td ON e.tipodocumento_id = td.tipodocumento_id ", new EstudianteRowMapper());
    }

    @Override
    public int updateEstudiante(int estudianteId, Estudiante estudiante) {
        try {
            String sql = "UPDATE ESTUDIANTE SET " +
                    "estudiante_numerodoc = ?, " +
                    "estudiante_nombres = ?, " +
                    "estudiante_apellidos = ?, " +
                    "estudiante_edad = ?, " +
                    "estudiante_celular = ?, " +
                    "estudiante_telefono = ?, " +
                    "estudiante_email = ?, " +
                    "WHERE estudiante_id = ?";
            return jdbcTemplate.update(sql,
                    estudiante.getEstudianteNumerodoc(),
                    estudiante.getEstudianteNombres(),
                    estudiante.getEstudianteApellidos(),
                    estudiante.getEstudianteEdad(),
                    estudiante.getEstudianteCelular(),
                    estudiante.getEstudianteTelefono(),
                    estudiante.getEstudianteEmail(),
                    estudianteId
            );
        } catch (Exception e) {
            throw new CustomException("Proceso fallido", 400);
        }
    }

    @Override
    public int deleteEstudiante(int estudianteId) {
        try {
            return jdbcTemplate.update("DELETE FROM ESTUDIANTE WHERE estudiante_id = ?", estudianteId);
        } catch (Exception e) {
            throw new CustomException("Proceso fallido", 400);
        }
    }

}

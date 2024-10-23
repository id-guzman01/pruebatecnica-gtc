package com.prueba.tecnica.Persistence.Repository.Impl;

import com.prueba.tecnica.Persistence.Repository.IGradoRepository;
import com.prueba.tecnica.Service.DTO.GradoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradoRepository implements IGradoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<GradoDTO> frindGrado() {
        return jdbcTemplate.query("SELECT " +
                "* FROM GRADO", new BeanPropertyRowMapper<>(GradoDTO.class));
    }
}

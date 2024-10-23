package com.prueba.tecnica.Persistence.Repository.Impl;

import com.prueba.tecnica.Persistence.Repository.ITipoDocumentoRepository;
import com.prueba.tecnica.Service.DTO.TipoDocumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoDocumentoRepository implements ITipoDocumentoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TipoDocumentoDTO> findTipoDocumento() {
        return jdbcTemplate.query("SELECT " +
                "* FROM TIPODOCUMENTO", new BeanPropertyRowMapper<>(TipoDocumentoDTO.class));
    }
}

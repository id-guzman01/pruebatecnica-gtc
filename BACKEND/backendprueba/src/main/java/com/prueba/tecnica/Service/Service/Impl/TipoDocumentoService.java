package com.prueba.tecnica.Service.Service.Impl;

import com.prueba.tecnica.Persistence.Repository.Impl.TipoDocumentoRepository;
import com.prueba.tecnica.Service.DTO.TipoDocumentoDTO;
import com.prueba.tecnica.Service.Service.ITipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoService implements ITipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumentoDTO> findTipoDocumento() {
        return tipoDocumentoRepository.findTipoDocumento();
    }
}

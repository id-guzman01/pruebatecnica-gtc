package com.prueba.tecnica.Persistence.Repository;

import com.prueba.tecnica.Service.DTO.TipoDocumentoDTO;

import java.util.List;

public interface ITipoDocumentoRepository {

    public List<TipoDocumentoDTO> findTipoDocumento();

}

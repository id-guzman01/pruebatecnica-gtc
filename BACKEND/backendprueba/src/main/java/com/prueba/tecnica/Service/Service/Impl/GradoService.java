package com.prueba.tecnica.Service.Service.Impl;

import com.prueba.tecnica.Persistence.Repository.Impl.GradoRepository;
import com.prueba.tecnica.Service.DTO.GradoDTO;
import com.prueba.tecnica.Service.Service.IGradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradoService implements IGradoService {

    @Autowired
    private GradoRepository gradRepository;

    @Override
    public List<GradoDTO> frindGrado() {
        return gradRepository.frindGrado();
    }
}

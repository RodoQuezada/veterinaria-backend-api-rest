package com.gazulabs.veterinariabackendapirest.app.models.services.impl;


import com.gazulabs.veterinariabackendapirest.app.api.v1.mapper.IPacienteMapper;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.repository.IPacienteRepository;
import com.gazulabs.veterinariabackendapirest.app.models.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements IPacienteService {

    private IPacienteMapper pacienteMapper;
    private IPacienteRepository pacienteRepository;

    @Autowired
    public void setPacienteMapper(IPacienteMapper pacienteMapper) {
        this.pacienteMapper = pacienteMapper;
    }

    public IPacienteMapper getPacienteMapper() {
        return pacienteMapper;
    }

    @Autowired
    public void setPacienteRepository(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public IPacienteRepository getPacienteRepository() {
        return pacienteRepository;
    }

    @Override
    public List<PacienteDTO> getAllPacientes() {
        return pacienteRepository
                .findAll()
                .stream()
                .map(paciente -> {
                    PacienteDTO pacienteDTO = pacienteMapper.pacienteToPacienteDTO(paciente);
                    return pacienteDTO;
                })
                .collect(Collectors.toList())
                ; }

    @Override
    public PacienteDTO getPacienteById(Long id) {
        return pacienteRepository.findById(id)
                .map(pacienteMapper::pacienteToPacienteDTO)
                .orElseThrow(RuntimeException::new)
                ; }


}

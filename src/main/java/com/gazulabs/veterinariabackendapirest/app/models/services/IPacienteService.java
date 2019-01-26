package com.gazulabs.veterinariabackendapirest.app.models.services;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteDTO;

import java.util.List;

public interface IPacienteService {

    List<PacienteDTO> getAllPacientes();

    PacienteDTO getPacienteById(Long id);

}

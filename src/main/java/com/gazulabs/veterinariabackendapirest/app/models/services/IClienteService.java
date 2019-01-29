package com.gazulabs.veterinariabackendapirest.app.models.services;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;

import java.util.List;

public interface IClienteService {


    List<ClienteDTO> getAllCLientes();

    ClienteDTO findClienteByNombre(String nombre);

    ClienteDTO createNewClienteDto(ClienteDTO clienteDTO);

}

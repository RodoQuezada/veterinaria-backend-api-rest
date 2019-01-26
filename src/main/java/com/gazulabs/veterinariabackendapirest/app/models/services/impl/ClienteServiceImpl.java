package com.gazulabs.veterinariabackendapirest.app.models.services.impl;

import com.gazulabs.veterinariabackendapirest.app.api.v1.mapper.IClienteMapper;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.repository.IClienteRepository;
import com.gazulabs.veterinariabackendapirest.app.models.services.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService {


    private final IClienteMapper clienteMapper;
    private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteMapper clienteMapper, IClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> getAllCLientes() {
        return clienteRepository
                .findAll()
                .stream()
                .map(clienteMapper::clienteToClienteDto)
                .collect(Collectors.toList());

    }

    @Override
    public ClienteDTO findClienteByNombre(String nombre) {
        return clienteMapper.clienteToClienteDto(clienteRepository.findClienteByNombre(nombre));
    }


}

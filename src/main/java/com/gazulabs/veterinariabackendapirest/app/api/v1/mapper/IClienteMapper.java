package com.gazulabs.veterinariabackendapirest.app.api.v1.mapper;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IClienteMapper {

    IClienteMapper CLIENTE_MAPPER = Mappers.getMapper(IClienteMapper.class);

    ClienteDTO clienteToClienteDto(Cliente cliente);


}

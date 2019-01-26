package com.gazulabs.veterinariabackendapirest.app.api.v1.mapper;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPacienteMapper {

    IPacienteMapper PACIENTE_MAPPER = Mappers.getMapper(IPacienteMapper.class);

    PacienteDTO pacienteToPacienteDTO(Paciente paciente);

    ClienteDTO clienteToClienteDTO(Cliente cliente);

    Cliente clienteDtoToCliente (ClienteDTO clienteDTO);

}

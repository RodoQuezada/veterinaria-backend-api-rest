package com.gazulabs.veterinariabackendapirest.app.api.v1.mapper;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;


public class IClienteMapperTest {

    public static final long ID = 1l;
    public static final String NOMBRE = "Rodolfo";
    public static final String APELLIDO = "Quezada";
    IClienteMapper clienteMapper = IClienteMapper.CLIENTE_MAPPER;

    @Test
    public void clienteToClienteDTO() {

        //given
        Cliente cliente = new Cliente();
        cliente.setId(ID);
        cliente.setNombre(NOMBRE);
        cliente.setApellido(APELLIDO);

        //when
        ClienteDTO clienteDTO = clienteMapper.clienteToClienteDto(cliente);

        //then
        assertEquals(Long.valueOf(ID), clienteDTO.getId());
        assertEquals(NOMBRE, clienteDTO.getNombre());
        assertEquals(APELLIDO, clienteDTO.getApellido());



    }
}
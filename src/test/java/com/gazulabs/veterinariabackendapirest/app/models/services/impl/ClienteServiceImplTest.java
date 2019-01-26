package com.gazulabs.veterinariabackendapirest.app.models.services.impl;

import com.gazulabs.veterinariabackendapirest.app.api.v1.mapper.IClienteMapper;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import com.gazulabs.veterinariabackendapirest.app.models.repository.IClienteRepository;
import net.minidev.json.writer.ArraysMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ClienteServiceImplTest {

    @Mock
    IClienteRepository clienteRepository;

    IClienteMapper clienteMapper = IClienteMapper.CLIENTE_MAPPER;

    ClienteServiceImpl clienteService;


    public static final long ID_CLIENTE = 1l;
    public static final String NOMBRE_CLIENTE = "Rodolfo";
    public static final String APELLIDO_CLIENTE = "Quezada";


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        clienteService = new ClienteServiceImpl(IClienteMapper.CLIENTE_MAPPER,clienteRepository);
    }

    @Test
    public void getAllCLientes() throws Exception{

        Cliente cliente = new Cliente();
        cliente.setId(ID_CLIENTE);
        cliente.setNombre(NOMBRE_CLIENTE);
        cliente.setApellido(APELLIDO_CLIENTE);

        Cliente cliente2 = new Cliente();
        cliente.setId(2l);
        cliente.setNombre("Rafael");
        cliente.setApellido(APELLIDO_CLIENTE);

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente, cliente2));
        List<ClienteDTO> clienteDTOList =  clienteService.getAllCLientes();
        assertEquals(2, clienteDTOList.size());

    }

    @Test
    public void findClienteByNombre() throws Exception {

        Cliente cliente = new Cliente();
        cliente.setId(ID_CLIENTE);
        cliente.setNombre(NOMBRE_CLIENTE);
        cliente.setApellido(APELLIDO_CLIENTE);

        when(clienteRepository.findClienteByNombre(anyString())).thenReturn(cliente);

        ClienteDTO clienteDTO = clienteService.findClienteByNombre(NOMBRE_CLIENTE);

   //   assertEquals(java.util.Optional.ofNullable(ID_CLIENTE), clienteDTO.getId());
        assertEquals(NOMBRE_CLIENTE, clienteDTO.getNombre());

    }
}
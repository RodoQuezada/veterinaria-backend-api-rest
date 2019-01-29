package com.gazulabs.veterinariabackendapirest.app.controllers.v1;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.services.IClienteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClienteControllerTest extends AbstractRestControllerTest{

    public static final String NOMBRE = "Rodolfo";

    @Mock
    IClienteService clienteService;

    @InjectMocks
    ClienteController clienteController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void testListClientes() throws Exception{

        ClienteDTO rodolfo = new ClienteDTO();
        rodolfo.setId(1l);
        rodolfo.setNombre("Rodolfo");
        rodolfo.setApellido("Quezada");

        ClienteDTO axel = new ClienteDTO();
        axel.setId(2l);
        axel.setNombre("Axel");
        axel.setApellido("Jelvez");

        List<ClienteDTO> clienteDTOS = Arrays.asList(rodolfo,axel);

        when(clienteService.getAllCLientes()).thenReturn(clienteDTOS);

        mockMvc.perform(get("/api/v1/clientes/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteDTOS", hasSize(2)));
    }

    @Test
    public void testGetByNombreCliente() throws Exception{

        ClienteDTO rodolfo = new ClienteDTO();
        rodolfo.setId(1l);
        rodolfo.setNombre("rodolfo");
        rodolfo.setApellido("quezada");

        when(clienteService.findClienteByNombre(anyString())).thenReturn(rodolfo);

        mockMvc.perform(get("/api/v1/clientes/rodolfo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", equalTo("rodolfo")));
    }

}
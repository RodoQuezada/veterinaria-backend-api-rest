package com.gazulabs.veterinariabackendapirest.app.controllers.v1;

import com.gazulabs.veterinariabackendapirest.app.api.v1.mapper.IPacienteMapper;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.services.IPacienteService;
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

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PacienteControllerTest {

    public static final String NOMBRE = "Rodolfo", APELLIDO = "Quezada", NOMBRE_PACIENTE = "Canela";

    @Mock
    IPacienteService pacienteService;

    @InjectMocks
    PacienteController pacienteController;

    MockMvc mockMvc;

    IPacienteMapper pacienteMapper = IPacienteMapper.PACIENTE_MAPPER;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pacienteController).build();
    }

    @Test
    public void testListPacientes() throws Exception{

        ClienteDTO rodolfo = new ClienteDTO();
        rodolfo.setNombre(NOMBRE);
        rodolfo.setApellido(APELLIDO);

        PacienteDTO canela = new PacienteDTO();
        canela.setNombre(NOMBRE_PACIENTE);
        canela.setCliente(pacienteMapper.clienteDtoToCliente(rodolfo));

        PacienteDTO monchito = new PacienteDTO();
        monchito.setNombre("Monchito");
        monchito.setCliente(pacienteMapper.clienteDtoToCliente(rodolfo));

        List<PacienteDTO> pacienteDTOList = Arrays.asList(canela,monchito);

        when(pacienteService.getAllPacientes()).thenReturn(pacienteDTOList);

        mockMvc.perform(get("/api/v1/pacientes/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pacienteDTOList", hasSize(2)));

    }


}
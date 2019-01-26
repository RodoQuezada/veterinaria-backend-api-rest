package com.gazulabs.veterinariabackendapirest.app.models.services.impl;

import com.gazulabs.veterinariabackendapirest.app.api.v1.mapper.IPacienteMapper;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Paciente;
import com.gazulabs.veterinariabackendapirest.app.models.repository.IPacienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PacienteServiceImplTest {

    @Mock
    IPacienteRepository pacienteRepository;

    IPacienteMapper pacienteMapper = IPacienteMapper.PACIENTE_MAPPER;

    PacienteServiceImpl pacienteService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pacienteService = new PacienteServiceImpl();
        pacienteService.setPacienteMapper(pacienteMapper);
        pacienteService.setPacienteRepository(pacienteRepository);
    }

    @Test
    public void getAllPacientes() throws Exception{

        Cliente rodolfo = new Cliente();
        rodolfo.setId(1l);
        rodolfo.setNombre("Rodolfo");
        rodolfo.setApellido("Quezada");

        Paciente canela = new Paciente();
        canela.setId(1l);
        canela.setNombre("Canela");
        canela.setCliente(rodolfo);

        Paciente burbuja = new Paciente();
        burbuja.setId(2l);
        burbuja.setNombre("Burbuja");
        burbuja.setCliente(rodolfo);

        when(pacienteRepository.findAll()).thenReturn(Arrays.asList(canela,burbuja));

        List<PacienteDTO> pacienteDTOS = pacienteService.getAllPacientes();

        assertEquals(2, pacienteDTOS.size());
        assertEquals("Rodolfo", pacienteDTOS.get(0).getCliente().getNombre());

    }

    @Test
    public void getPacienteById() throws Exception{

        Cliente rodolfo = new Cliente();
        rodolfo.setId(1l);
        rodolfo.setNombre("Rodolfo");
        rodolfo.setApellido("Quezada");

        Paciente canela = new Paciente();
        canela.setId(1l);
        canela.setNombre("Canela");
        canela.setCliente(rodolfo);

        when(pacienteRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(canela));

        PacienteDTO pacienteDTO = pacienteService.getPacienteById(1l);

        assertEquals("Canela", pacienteDTO.getNombre());
    }
}
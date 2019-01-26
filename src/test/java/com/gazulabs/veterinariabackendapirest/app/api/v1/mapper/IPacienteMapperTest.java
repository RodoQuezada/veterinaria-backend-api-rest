package com.gazulabs.veterinariabackendapirest.app.api.v1.mapper;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteDTO;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Paciente;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPacienteMapperTest {

    public static final long ID_CLIENTE = 1l;
    public static final String NOMBRE_CLIENTE = "Rodolfo";
    public static final String APELLIDO_CLIENTE = "Quezada";

    public static final long ID = 1l;
    public static final String NOMBRE = "Walther";

    IPacienteMapper pacienteMapper = IPacienteMapper.PACIENTE_MAPPER;

    @Test
    public void pacienteToPacienteDTO() {

        Cliente cliente = new Cliente();
        cliente.setId(ID_CLIENTE);
        cliente.setNombre(NOMBRE_CLIENTE);
        cliente.setApellido(APELLIDO_CLIENTE);

        Paciente paciente = new Paciente();
        paciente.setId(ID);
        paciente.setNombre(NOMBRE);
        paciente.setCliente(cliente);

        PacienteDTO pacienteDTO = pacienteMapper.pacienteToPacienteDTO(paciente);


        assertEquals(NOMBRE_CLIENTE, pacienteDTO.getCliente().getNombre());

    }
}
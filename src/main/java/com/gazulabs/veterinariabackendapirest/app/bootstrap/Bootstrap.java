package com.gazulabs.veterinariabackendapirest.app.bootstrap;

import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import com.gazulabs.veterinariabackendapirest.app.models.entity.Paciente;
import com.gazulabs.veterinariabackendapirest.app.models.repository.IClienteRepository;
import com.gazulabs.veterinariabackendapirest.app.models.repository.IPacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final IPacienteRepository pacienteRepository;
    private final IClienteRepository clienteRepository;

    public Bootstrap(IPacienteRepository pacienteRepository, IClienteRepository clienteRepository) {
        this.pacienteRepository = pacienteRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {


       Cliente rodolfo = new Cliente();
       rodolfo.setId(1l);
       rodolfo.setNombre("Rodolfo");
       rodolfo.setApellido("Quezada");

       clienteRepository.save(rodolfo);

       Paciente walther = new Paciente();
       walther.setId(1l);
       walther.setNombre("Walther");
       walther.setCliente(rodolfo);

       pacienteRepository.save(walther);

        System.out.println("-- id ingresado :  " + rodolfo.getId());
    }



}

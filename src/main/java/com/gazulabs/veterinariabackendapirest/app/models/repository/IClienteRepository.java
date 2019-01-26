package com.gazulabs.veterinariabackendapirest.app.models.repository;

import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findClienteByNombre(String nombre);


}

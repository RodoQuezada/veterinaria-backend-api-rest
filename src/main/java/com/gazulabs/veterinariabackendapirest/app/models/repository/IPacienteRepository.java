package com.gazulabs.veterinariabackendapirest.app.models.repository;

import com.gazulabs.veterinariabackendapirest.app.models.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}

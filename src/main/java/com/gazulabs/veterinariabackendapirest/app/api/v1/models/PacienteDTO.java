package com.gazulabs.veterinariabackendapirest.app.api.v1.models;

import com.gazulabs.veterinariabackendapirest.app.models.entity.Cliente;
import lombok.Data;

@Data
public class PacienteDTO {

    private Long id;
    private String nombre;
    private Cliente cliente;

}

package com.gazulabs.veterinariabackendapirest.app.api.v1.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PacienteListDTO {

    List<PacienteDTO> pacienteDTOList;

}

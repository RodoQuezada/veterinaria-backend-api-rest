package com.gazulabs.veterinariabackendapirest.app.controllers.v1;


import com.gazulabs.veterinariabackendapirest.app.api.v1.models.PacienteListDTO;
import com.gazulabs.veterinariabackendapirest.app.models.services.IPacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/pacientes/")
public class PacienteController {

    private final IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<PacienteListDTO> getListofPacientes(){
        return new ResponseEntity<PacienteListDTO>(new PacienteListDTO(pacienteService.getAllPacientes()), HttpStatus.OK);
    }





}

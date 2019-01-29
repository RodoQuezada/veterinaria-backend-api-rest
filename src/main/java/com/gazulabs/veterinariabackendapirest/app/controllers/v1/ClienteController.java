package com.gazulabs.veterinariabackendapirest.app.controllers.v1;

import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteDTO;
import com.gazulabs.veterinariabackendapirest.app.api.v1.models.ClienteListDTO;
import com.gazulabs.veterinariabackendapirest.app.models.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<ClienteListDTO> getAllClientes(){
        return new ResponseEntity<ClienteListDTO>(
                new ClienteListDTO(clienteService.getAllCLientes()), HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<ClienteDTO> getClienteByNombre(@PathVariable String nombre){
        return new ResponseEntity<ClienteDTO>(
          clienteService.findClienteByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createNewCliente(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<ClienteDTO>(clienteService.createNewClienteDto(clienteDTO), HttpStatus.CREATED);
    }

}

package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;


    @GetMapping
    public ResponseEntity<List<PacienteModel>> buscarTodos() {
        List<PacienteModel> paciente = service.buscarTodos();
        return ResponseEntity.ok().body(paciente);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteModel> buscarUm(@PathVariable Integer id) {
        var paciente = service.buscarUm(id);
        return ResponseEntity.ok().body(paciente);
    }

    @PostMapping
    public ResponseEntity<PacienteModel> cadastraPaciente(@RequestBody CadastraUsuarioDTO obj) {
        PacienteModel paciente = service.cadastrarPaciente(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }
}

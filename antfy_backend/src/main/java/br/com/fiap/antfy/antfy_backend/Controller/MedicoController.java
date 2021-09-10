package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

    @Autowired
    MedicoService medicoService;


    @GetMapping
    public ResponseEntity<List<MedicoModel>> buscarTodos() {
        List<MedicoModel> medico = medicoService.buscarTodos();
        return ResponseEntity.ok().body(medico);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoModel> buscarUm(@PathVariable Integer id) {
        var medico = medicoService.buscarUm(id);
        return ResponseEntity.ok().body(medico);
    }

    @PostMapping
    public ResponseEntity<MedicoModel> cadastraMedico(@RequestBody CadastraUsuarioDTO obj) {
        MedicoModel medico = medicoService.cadastrarMedico(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getIdMedico()).toUri();
        return ResponseEntity.created(uri).body(medico);
    }
}

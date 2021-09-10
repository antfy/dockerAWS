package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.ConsultaModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.*;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {

    @Autowired
    ConsultaService service;


    @GetMapping
    public ResponseEntity<List<SintomasApiDTO>> buscarSintomas() {
        List<SintomasApiDTO> listaSintomas = service.buscarSintomas();
        return ResponseEntity.ok().body(listaSintomas);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<ConsultaModel>> buscarConsultas(@PathVariable String email) {
        List<ConsultaModel> listaSintomas = service.buscarConsulta(email);
        return ResponseEntity.ok().body(listaSintomas);
    }

    @PostMapping
    public ResponseEntity<RetornoCriaConsultaDTO> cadastraPaciente(@RequestBody CriaConsultaDTO criaConsultaDTO) {
        var consulta = service.criarConsulta(criaConsultaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consulta.getConsulta().getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }

    @PutMapping
    public ResponseEntity<ConsultaModel> confirmarConsulta(@RequestBody ConfirmaConsultaDTO confirmaConsultaDTO) {
        var consulta = service.confirmarConsulta(confirmaConsultaDTO);
        return ResponseEntity.ok().body(consulta);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultaModel> finalizarConsulta(@PathVariable Integer id) {
        var consulta = service.finalizarConsulta(id);
        return ResponseEntity.ok().body(consulta);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Integer id) {
        service.cancelarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}

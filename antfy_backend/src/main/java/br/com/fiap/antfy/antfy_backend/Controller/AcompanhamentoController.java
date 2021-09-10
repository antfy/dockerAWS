package br.com.fiap.antfy.antfy_backend.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraAcompanhamentoDTO;
import br.com.fiap.antfy.antfy_backend.services.AcompanhamentoService;

@RestController
@RequestMapping(value = "/acompanhamentos")
public class AcompanhamentoController {

    @Autowired
    AcompanhamentoService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<List<AcompanhamentoModel>> buscarProPaciente(@PathVariable Integer id) {
        List<AcompanhamentoModel> acompanhamento = service.buscarPorPaciente(id);
        return ResponseEntity.ok().body(acompanhamento);
    }

    @PostMapping
    public ResponseEntity<AcompanhamentoModel> cadrastrarAcompanhamento(@RequestBody CadastraAcompanhamentoDTO obj) {
        AcompanhamentoModel acompanhamento = service.cadrastrarAcompanhamento(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acompanhamento.getIdAcompanhamento()).toUri();
        return ResponseEntity.created(uri).body(acompanhamento);
    }
}

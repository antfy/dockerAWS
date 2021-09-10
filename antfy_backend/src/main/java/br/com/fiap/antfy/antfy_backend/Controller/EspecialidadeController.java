package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeController {

        @Autowired
        EspecialidadeService service;


    @GetMapping
    public ResponseEntity<List<EspecialidadeModel>> buscarTodos(){
        List<EspecialidadeModel> especialidade = service.buscarTodos();
        return  ResponseEntity.ok().body(especialidade);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EspecialidadeModel> buscarUm(@PathVariable Integer id){
        EspecialidadeModel especialidade = service.buscarUm(id);
        return ResponseEntity.ok().body(especialidade);
    }


    @PostMapping
    public ResponseEntity<EspecialidadeModel> cadastraEspecialidade(@RequestBody EspecialidadeModel obj){
        EspecialidadeModel especialidade = service.cadrastrarEpecialidade(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(especialidade.getEspecialidade()).toUri();
        return ResponseEntity.created(uri).body(especialidade);
    }
}

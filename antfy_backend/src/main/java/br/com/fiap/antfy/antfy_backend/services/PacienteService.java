package br.com.fiap.antfy.antfy_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.antfy.antfy_backend.Model.EnderecoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<PacienteModel> buscarTodos() {
        List<PacienteModel> paciente = repository.findAll();
        return paciente;
    }

    public PacienteModel buscarUm(Integer id){
        Optional<PacienteModel> paciente = repository.findById(id);
        return paciente.get();
    }


    public PacienteModel cadastrarPaciente(CadastraUsuarioDTO obj) {

        PacienteModel paciente = new PacienteModel(obj.getNome(),
                obj.getEmail(), passwordEncoder.encode(obj.getSenha()), obj.getCpf(),
                new EnderecoModel(obj.getLagradouro(), obj.getBairro(), obj.getCidade(), obj.getEstado(),
                obj.getPais(), obj.getComplemento(), obj.getCep(), obj.getNumero()));

        return repository.save(paciente);
    }

    public PacienteModel findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

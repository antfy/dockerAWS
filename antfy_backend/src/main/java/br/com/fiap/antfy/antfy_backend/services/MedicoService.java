package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.EnderecoModel;
import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    @Autowired
    EspecialidadeService serviceEspecialidade;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<MedicoModel> buscarTodos() {
        List<MedicoModel> medicos = repository.findAll();
        return medicos;
    }

    public List<MedicoModel> buscarPorEspecialidade(String especialidade) {
        var especialidadeID = serviceEspecialidade.buscarUmPorNome(especialidade);

        List<MedicoModel> medicos = repository.findByEspecialidade(especialidadeID);
        return medicos;
    }

    public MedicoModel cadastrarMedico(CadastraUsuarioDTO obj) {

        MedicoModel medico = new MedicoModel(obj.getNome(),
                obj.getEmail(), passwordEncoder.encode(obj.getSenha()), obj.getCrm(),
                serviceEspecialidade.buscarUm(obj.getEspecialidade()),
                new EnderecoModel(obj.getLagradouro(), obj.getBairro(), obj.getCidade(), obj.getEstado(),
                obj.getPais(), obj.getComplemento(), obj.getCep(), obj.getNumero()));

        return repository.save(medico);
    }

    public MedicoModel buscarUm(Integer medicoID) {
        Optional<MedicoModel> obj = repository.findById(medicoID);
        return obj.get();
    }

    public MedicoModel findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

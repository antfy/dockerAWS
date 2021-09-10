package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EspecialidadeService implements Serializable {
    private static final long serialVersionUID = 1L;


    @Autowired
    EspecialidadeRepository repository;

    public EspecialidadeModel buscarUm(Integer id){
        EspecialidadeModel model = repository.getOne(id);
        return model ;
    }

    public EspecialidadeModel buscarUmPorNome(String especialidade){
        EspecialidadeModel model = repository.findByEspecialidade(especialidade);
        return model ;
    }

    public List<EspecialidadeModel> buscarTodos(){
        return repository.findAll();
    }

    public EspecialidadeModel cadrastrarEpecialidade(EspecialidadeModel especialidade){
        return repository.save(especialidade);
    }
}

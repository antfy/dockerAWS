package br.com.fiap.antfy.antfy_backend.Repository;

import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface  MedicoRepository extends JpaRepository<MedicoModel, Integer> {

    @Transactional(readOnly = true)
    MedicoModel findByEmail(String email);

    @Transactional(readOnly = true)
    List<MedicoModel> findByEspecialidade(EspecialidadeModel especialidade);
}

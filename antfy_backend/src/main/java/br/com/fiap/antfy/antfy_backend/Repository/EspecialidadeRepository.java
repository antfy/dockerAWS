package br.com.fiap.antfy.antfy_backend.Repository;

import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EspecialidadeRepository extends JpaRepository<EspecialidadeModel, Integer> {
    @Transactional(readOnly = true)
    EspecialidadeModel findByEspecialidade(String especialidade);
}

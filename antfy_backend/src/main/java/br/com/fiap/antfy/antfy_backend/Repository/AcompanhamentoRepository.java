package br.com.fiap.antfy.antfy_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;

public interface AcompanhamentoRepository extends JpaRepository<AcompanhamentoModel, Integer> {

    @Transactional(readOnly = true)
    List<AcompanhamentoModel> findByPaciente(PacienteModel paciente);
}

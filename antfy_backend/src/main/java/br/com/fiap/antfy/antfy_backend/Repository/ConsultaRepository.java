package br.com.fiap.antfy.antfy_backend.Repository;


import br.com.fiap.antfy.antfy_backend.Model.ConsultaModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {

    @Transactional(readOnly = true)
    List<ConsultaModel> findByMedico(MedicoModel medico);

    @Transactional(readOnly = true)
    List<ConsultaModel> findByPaciente(PacienteModel pacente);
}

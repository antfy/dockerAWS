package br.com.fiap.antfy.antfy_backend.Repository;


import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

    @Transactional(readOnly = true)
    PacienteModel findByEmail(String email);
}

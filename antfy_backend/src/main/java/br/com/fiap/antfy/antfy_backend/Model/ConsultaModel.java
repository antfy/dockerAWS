package br.com.fiap.antfy.antfy_backend.Model;

import br.com.fiap.antfy.antfy_backend.Enum.StatusConsulta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_01_consulta")
public class ConsultaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    @Column(name = "data_agendada")
    private Date dataAgendada;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "paciente")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "medico")
    private MedicoModel medico;

    public ConsultaModel(Date dataInicio, Integer status, PacienteModel paciente) {
        this.dataInicio = dataInicio;
        this.status = status;
        this.paciente = paciente;
    }
}

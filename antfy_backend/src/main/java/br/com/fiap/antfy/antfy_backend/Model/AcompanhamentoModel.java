package br.com.fiap.antfy.antfy_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_03_acompanhamento")
public class AcompanhamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acompanhamento")
    private Integer idAcompanhamento;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "temperatura")
    private Double temperatura;

    @Column(name = "precao")
    private String precao;

    @Column(name = "batimento_cardiaco")
    private Integer batimento;

    @Column(name = "data_medicao")
    private Date data_medicao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "paciente")
    private PacienteModel paciente;

}

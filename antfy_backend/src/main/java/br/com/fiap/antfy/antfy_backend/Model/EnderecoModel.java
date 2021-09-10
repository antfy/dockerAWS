package br.com.fiap.antfy.antfy_backend.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_04_enderecos")
public class EnderecoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enderecos")
    private Integer idEndereco;

    @Column(name = "lagradouro")
    private String lagradouro;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private Integer cep;

    @Column(name = "numero")
    private Integer numero;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private PacienteModel paciente;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private MedicoModel medico;

    public EnderecoModel(String lagradouro, String bairro, String cidade, String estado, String pais, String complemento, Integer cep, Integer numero) {
        this.lagradouro = lagradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.complemento = complemento;
        this.cep = cep;
        this.numero = numero;
    }
}

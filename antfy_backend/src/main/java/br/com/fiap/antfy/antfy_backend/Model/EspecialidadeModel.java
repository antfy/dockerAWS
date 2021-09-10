package br.com.fiap.antfy.antfy_backend.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_07_especialidade")
public class EspecialidadeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_especialidade")
    private Integer idEspecialidade;

    @Column(name = "nome_especialidade")
    private String especialidade;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidade")
    private List<MedicoModel> medico;

}


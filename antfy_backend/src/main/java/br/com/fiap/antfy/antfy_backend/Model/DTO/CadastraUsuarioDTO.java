package br.com.fiap.antfy.antfy_backend.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CadastraUsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String crm;
    private Integer especialidade;
    private String lagradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String complemento;
    private Integer cep;
    private Integer numero;
}

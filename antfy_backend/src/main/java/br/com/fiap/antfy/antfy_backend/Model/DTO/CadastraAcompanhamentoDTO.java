package br.com.fiap.antfy.antfy_backend.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CadastraAcompanhamentoDTO {

    private Double peso;
    private Double altura;
    private Double temperatura;
    private String precao;
    private Integer batimento;
    private Integer paciente;
}

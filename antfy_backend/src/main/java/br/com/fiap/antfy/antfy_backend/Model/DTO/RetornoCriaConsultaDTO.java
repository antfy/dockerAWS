package br.com.fiap.antfy.antfy_backend.Model.DTO;

import br.com.fiap.antfy.antfy_backend.Model.ConsultaModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetornoCriaConsultaDTO {
    private ConsultaModel consulta;
    private List<MedicoModel> listaMedico;
}

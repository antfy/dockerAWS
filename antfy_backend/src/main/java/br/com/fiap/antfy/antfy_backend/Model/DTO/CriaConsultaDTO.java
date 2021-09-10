package br.com.fiap.antfy.antfy_backend.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriaConsultaDTO {
        private String listaSintomaId;
        private Integer pacenteID;
}

package br.com.fiap.antfy.antfy_backend.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomasApiDTO {
        private String sintomaId;
        private String sintoma;
        private String parteDoCorpo;
        private String regiaoDoCorpo;
}

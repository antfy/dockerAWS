package br.com.fiap.antfy.antfy_backend.Enum;

public enum StatusConsulta {

    CONSULTA_CRIADA(1, "CONSULTA_CRIADA"),
    CONSULTA_ATENDIDA(2, "CONSULTA_ATENDIDA"),
    CONSULTA_AGENDADA(3, "CONSULTA_AGENDADA"),
    CONSULTA_CANCELADA(4, "CONSULTA_CANCELADA");

    private Integer code;
    private String descricao;

    private StatusConsulta(Integer code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusConsulta valueOf(Integer code) {
        for (StatusConsulta value : StatusConsulta.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("invalide StatusPagamento code");

    }
}
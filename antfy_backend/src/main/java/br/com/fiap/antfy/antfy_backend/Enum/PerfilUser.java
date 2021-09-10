package br.com.fiap.antfy.antfy_backend.Enum;

public enum PerfilUser {

    ADMIN(1, "ROLE_ADMIN"), MEDICO(2, "ROLE_MEDICO"), PACIENTE(3, "ROLE_PACIENTE");

    private Integer code;
    private String descricao;

    private PerfilUser(Integer code, String descricao) {
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

    public static PerfilUser valueOf(Integer code) {
        for (PerfilUser value : PerfilUser.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("invalide StatusPagamento code");

    }
}
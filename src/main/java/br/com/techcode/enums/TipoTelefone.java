package br.com.techcode.enums;

/**
 *
 * @author AndreGustavo
 */
public enum TipoTelefone {

    CELULAR("Celular"),
    FIXO("Fixo");
    private String descricao;

    private TipoTelefone(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

package br.com.bycodesign.enums;

/**
 * @author Daniel Franco
 * @since 29/08/2014 11:42
 */
public enum TipoPeso {

    SEM_QUIMONO("Sem Quimono"),
    QUIMONO_LISO("Quimono Liso"),
    QUIMONO_TRANCADO("Quimono Trançado");

    String descricao;

    TipoPeso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}

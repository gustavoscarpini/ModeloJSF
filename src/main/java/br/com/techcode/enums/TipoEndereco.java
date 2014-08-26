/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.enums;

/**
 *
 * @author boy
 */
public enum TipoEndereco {

    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    COBRANCA("Cobrança"),
    CORRESPONDENCIA("Correspondência"),
    RURAL("Rural"),
    OUTROS("Outros");
    private String descricao;

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.enums;

/**
 *
 * @author AndreGustavo
 */
public enum TipoEmpresa {

    INDEFINIDO("Indefinido"),
    MICRO("Micro-ME"),
    PEQUENA("Pequena-EPP"),
    NORMAL("Normal"),
    GRANDE("Grande");
    private String descricao;

    private TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao ;
    }
    
    
}

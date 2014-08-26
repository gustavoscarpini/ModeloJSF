/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.enums;

/**
 *
 * @author AndreGustavo
 */
public enum TipoArquivo {

    FOTO_PESSOAL("Foto Pessoal"),
    DOCUMENTO("Documento");
    private String descricao;

    private TipoArquivo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}

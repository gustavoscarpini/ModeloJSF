package br.com.exemplo.util;

/**
 *
 * @author Gustavo
 */
public interface Cadastravel {

    public String getCaminhoPadrao();
    
    public Long getId();

    public Validacao executaValidacao();
}

package br.com.bycodesign.enums;

/**
 * @author Daniel Franco
 * @since 29/08/2014 09:13
 */
public enum Sexo {

    MASCULINO("Masculino", true),
    FEMININO("Feminino", true),
    AMBOS("Ambos", false);

    String descricao;
    boolean visivel;

    Sexo(String descricao, boolean visivel) {
        this.descricao = descricao;
        this.visivel = visivel;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean isVisivel() {
        return this.visivel;
    }
}

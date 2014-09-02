package br.com.bycodesign.enums;

/**
 * @author Daniel Franco
 * @since 29/08/2014 08:53
 */
public enum Graduacao {

    BRANCA("Branca", 1),
    AZUL("Azul", 2),
    ROXA("Roxa", 3),
    MARROM("Marrom", 4),
    PRETA("Preta", 5);

    String descricao;
    Integer ordem;

    Graduacao(String descricao, int ordem) {
        this.descricao = descricao;
        this.ordem = ordem;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Integer getOrdem() {
        return this.ordem;
    }

}

package br.com.bycodesign.enums;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static br.com.bycodesign.enums.CategoriaIdade.*;

/**
 * @author Daniel Franco
 * @since 29/08/2014 08:55
 */
public enum CategoriaPeso {

    GALO("Galo", 1),
    PLUMA("Pluma", 2),
    PENA("Pena", 3),
    LEVE("Leve", 4),
    MEDIO("Médio", 5),
    MEIO_PESADO("Meio Pesado", 6),
    PESADO("Pesado", 7),
    SUPER_PESADO("Super Pesado", 8),
    PESADISSIMO("Pesadíssimo", 9),
    ;

    String descricao;
    Integer ordem;

    CategoriaPeso(String descricao, Integer ordem) {
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

package br.com.bycodesign.enums;

/**
 * @author Daniel Franco
 * @since 29/08/2014 08:30
 */
public enum CategoriaIdade {

    PRE_MIRIM_1("Pré-Mirim 1 (4 anos)", 4, 4),
    PRE_MIRIM_2("Pré-Mirim 2 (5 anos)", 5, 5),
    PRE_MIRIM_3("Pré-Mirim 3 (6 anos)", 6, 6),
    MIRIM_1("Mirim 1 (7 anos)", 7, 7),
    MIRIM_2("Mirim 2 (8 anos)", 8, 8),
    MIRIM_3("Mirim 3 (9 anos)", 9, 9),
    INFANTIL_1("Infantil 1 (10 anos)", 10, 10),
    INFANTIL_2("Infantil 2 (11 anos)", 11, 11),
    INFANTIL_3("Infantil 3 (12 anos)", 12, 12),
    INFANTO_JUVENIL_1("Infanto Juvenil 1 (13 anos)", 13, 13),
    INFANTO_JUVENIL_2("Infanto Juvenil 2 (14 anos)", 14, 14),
    INFANTO_JUVENIL_3("Infanto Juvenil 3 (15 anos)", 15, 15),
    JUVENIL_1("Juvenil 1 (16 anos)", 16, 16),
    JUVENIL_2("Juvenil 2 (17 anos)", 17, 17),
    ADULTO("Adulto (18 a 29 anos)", 18, 29),
    MASTER("Master (30 a 35 anos)", 30, 35),
    SENIOR_1("Sênior 1 (36 a 40 anos)", 36, 40),
    SENIOR_2("Sênior 2 (41 a 45 anos)", 41, 45),
    SENIOR_3("Sênior 3 (46 a 50 anos)", 46, 50),
    SENIOR_4("Sênior 4 (51 a 55 anos)", 51, 55),
    SENIOR_5("Sênior 5 (56 anos em diante)", 56, Integer.MAX_VALUE)
    ;

    String descricao;
    Integer idadeMinima;
    Integer idadeMaxima;

    CategoriaIdade(String descricao, Integer idadeMinima, Integer idadeMaxima) {
        this.descricao = descricao;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Integer getIdadeMinima() {
        return this.idadeMinima;
    }

    public Integer getIdadeMaxima() {
        return this.idadeMaxima;
    }

}

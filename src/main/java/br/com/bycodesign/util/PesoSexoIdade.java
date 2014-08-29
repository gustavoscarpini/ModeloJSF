package br.com.bycodesign.util;

import br.com.bycodesign.enums.CategoriaIdade;
import br.com.bycodesign.enums.CategoriaPeso;
import br.com.bycodesign.enums.Sexo;
import br.com.bycodesign.util.comparator.ComparatorCategoriaIdade;
import br.com.bycodesign.util.comparator.ComparatorCategoriaPeso;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @author Daniel Franco
 * @since 29/08/2014 09:47
 */
public final class PesoSexoIdade implements Comparable<PesoSexoIdade> {

    private static final ComparatorCategoriaIdade comparatorIdade = new ComparatorCategoriaIdade();
    private static final ComparatorCategoriaPeso comparatorPeso = new ComparatorCategoriaPeso();

    private Sexo sexo;
    private CategoriaIdade categoriaIdade;
    private CategoriaPeso categoriaPeso;
    private BigDecimal pesoSemQuimono;
    private BigDecimal pesoQuimonoLiso;
    private BigDecimal pesoQUimonoTrancado;
    private boolean permiteAbsoluto;

    public PesoSexoIdade(CategoriaPeso categoriaPeso, CategoriaIdade categoriaIdade, Sexo sexo, BigDecimal pesoSemQuimono, BigDecimal pesoQuimonoLiso, BigDecimal pesoQuimonoTrancado, boolean permiteAbsoluto) {
        this.sexo = sexo;
        this.categoriaIdade = categoriaIdade;
        this.categoriaPeso = categoriaPeso;
        this.pesoSemQuimono = pesoSemQuimono;
        this.pesoQuimonoLiso = pesoQuimonoLiso;
        this.pesoQUimonoTrancado = pesoQuimonoTrancado;
        this.permiteAbsoluto = permiteAbsoluto;
    }

    public PesoSexoIdade(CategoriaPeso categoriaPeso, CategoriaIdade categoriaIdade, Sexo sexo, String pesoSemQuimono, String pesoQuimonoLiso, String pesoQuimonoTrancado, boolean permiteAbsoluto) {
        this.sexo = sexo;
        this.categoriaIdade = categoriaIdade;
        this.categoriaPeso = categoriaPeso;
        this.pesoSemQuimono = new BigDecimal(pesoSemQuimono);
        if (pesoQuimonoLiso != null) {
            this.pesoQuimonoLiso = new BigDecimal(pesoQuimonoLiso);
        }
        this.pesoQUimonoTrancado = new BigDecimal(pesoQuimonoTrancado);
        this.permiteAbsoluto = permiteAbsoluto;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public CategoriaIdade getCategoriaIdade() {
        return categoriaIdade;
    }

    public CategoriaPeso getCategoriaPeso() {
        return categoriaPeso;
    }

    public BigDecimal getPesoSemQuimono() {
        return pesoSemQuimono;
    }

    public BigDecimal getPesoQuimonoLiso() {
        return pesoQuimonoLiso;
    }

    public BigDecimal getPesoQuimonoTrancado() {
        return pesoQUimonoTrancado;
    }

    @Override
    public int compareTo(PesoSexoIdade outro) {
        int idade = comparatorIdade.compare(this.categoriaIdade, outro.getCategoriaIdade());
        if (idade != 0) {
            return idade;
        }
        int peso = comparatorPeso.compare(this.categoriaPeso, outro.categoriaPeso);
        if (peso != 0) {
            return peso;
        }
        int sexo = this.sexo.compareTo(outro.getSexo());
        if (sexo != 0) {
            return sexo;
        }
        return pesoSemQuimono.compareTo(outro.getPesoSemQuimono());
    }
}

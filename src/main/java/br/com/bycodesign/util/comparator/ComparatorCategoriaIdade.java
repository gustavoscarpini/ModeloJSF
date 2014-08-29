package br.com.bycodesign.util.comparator;

import br.com.bycodesign.enums.CategoriaIdade;

import java.util.Comparator;

/**
 * @author Daniel Franco
 * @since 29/08/2014 11:48
 */
public class ComparatorCategoriaIdade implements Comparator<CategoriaIdade> {

    @Override
    public int compare(CategoriaIdade o1, CategoriaIdade o2) {
        return ((Integer)o1.ordinal()).compareTo(o2.ordinal());
    }
}

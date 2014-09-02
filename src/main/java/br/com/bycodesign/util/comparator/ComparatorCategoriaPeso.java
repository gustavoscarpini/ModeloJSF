package br.com.bycodesign.util.comparator;

import br.com.bycodesign.enums.CategoriaPeso;

import java.util.Comparator;

/**
 * @author Daniel Franco
 * @since 29/08/2014 11:52
 */
public class ComparatorCategoriaPeso implements Comparator<CategoriaPeso> {

    @Override
    public int compare(CategoriaPeso o1, CategoriaPeso o2) {
        return ((Integer)o1.getOrdem()).compareTo(o2.getOrdem());
    }
}

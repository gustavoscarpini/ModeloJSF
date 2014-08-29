package br.com.bycodesign.util.comparator;

import br.com.bycodesign.enums.Graduacao;

import java.util.Comparator;

/**
 * @author Daniel Franco
 * @since 29/08/2014 11:44
 */
public class ComparatorGraduacao implements Comparator<Graduacao> {

    @Override
    public int compare(Graduacao o1, Graduacao o2) {
        return o1.getOrdem().compareTo(o2.getOrdem());
    }
}

package br.com.bycodesign.util;

import br.com.bycodesign.enums.CategoriaIdade;
import br.com.bycodesign.enums.CategoriaPeso;
import br.com.bycodesign.enums.Sexo;
import br.com.bycodesign.enums.TipoPeso;

import java.math.BigDecimal;
import java.util.*;

import static br.com.bycodesign.enums.CategoriaIdade.*;
import static br.com.bycodesign.enums.CategoriaPeso.*;
import static br.com.bycodesign.enums.Sexo.*;
import static java.util.Calendar.YEAR;

/**
 * @author Daniel Franco
 * @since 29/08/2014 10:19
 */
public final class TabelaPeso {

    private TabelaPeso() {
        lista.addAll(galo());
        lista.addAll(pluma());
        lista.addAll(pena());
        lista.addAll(leve());
        lista.addAll(medio());
        lista.addAll(meioPesado());
        lista.addAll(pesado());
        lista.addAll(superPesado());
        lista.addAll(pesadissimo());
    }

    private List<PesoSexoIdade> lista = new ArrayList<>();

    public List<PesoSexoIdade> galo() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(GALO, INFANTIL_1, AMBOS, "24.999", "26.300", "27.000", false));
        retorno.add(new PesoSexoIdade(GALO, INFANTIL_2, AMBOS, "27.999", "29.400", "30.200", false));
        retorno.add(new PesoSexoIdade(GALO, INFANTIL_3, AMBOS, "29.999", "31.400", "32.200", false));
        retorno.add(new PesoSexoIdade(GALO, INFANTO_JUVENIL_1, AMBOS, "33.999", "35.400", "36.200", false));
        retorno.add(new PesoSexoIdade(GALO, INFANTO_JUVENIL_2, AMBOS, "37.999", "39.500", "40.300", false));
        retorno.add(new PesoSexoIdade(GALO, INFANTO_JUVENIL_3, AMBOS, "41.999", "43.500", "44.300", false));
        retorno.add(new PesoSexoIdade(GALO, JUVENIL_1, MASCULINO, "45.999", null, "48.500", false));
        retorno.add(new PesoSexoIdade(GALO, JUVENIL_2, MASCULINO, "50.999", null, "53.500", false));
        retorno.add(new PesoSexoIdade(GALO, JUVENIL_1, FEMININO, "41.999", null, "44.300", false));
        retorno.add(new PesoSexoIdade(GALO, ADULTO, MASCULINO, "54.999", null, "57.500", true));
        retorno.add(new PesoSexoIdade(GALO, ADULTO, FEMININO, "45.999", null, "48.500", true));
        return retorno;
    }

    public List<PesoSexoIdade> pluma() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(PLUMA, PRE_MIRIM_1, AMBOS, "12.999", "14.200", "14.700", false));
        retorno.add(new PesoSexoIdade(PLUMA, PRE_MIRIM_2, AMBOS, "14.999", "16.200", "17.900", false));
        retorno.add(new PesoSexoIdade(PLUMA, PRE_MIRIM_3, AMBOS, "16.999", "18.200", "18.900", false));
        retorno.add(new PesoSexoIdade(PLUMA, MIRIM_1, AMBOS, "18.999", "21.999", "24.999", false));
        retorno.add(new PesoSexoIdade(PLUMA, MIRIM_2, AMBOS, "20.500", "23.300", "26.300", false));
        retorno.add(new PesoSexoIdade(PLUMA, MIRIM_3, AMBOS, "21.000", "24.000", "27.000", false));
        retorno.add(new PesoSexoIdade(PLUMA, INFANTIL_1, AMBOS, "27.999", "29.400", "30.200", false));
        retorno.add(new PesoSexoIdade(PLUMA, INFANTIL_2, AMBOS, "30.900", "32.400", "33.200", false));
        retorno.add(new PesoSexoIdade(PLUMA, INFANTIL_3, AMBOS, "33.999", "35.400", "36.200", false));
        retorno.add(new PesoSexoIdade(PLUMA, INFANTO_JUVENIL_1, AMBOS, "37.999", "39.500", "40.300", false));
        retorno.add(new PesoSexoIdade(PLUMA, INFANTO_JUVENIL_2, AMBOS, "41.999", "43.500", "44.300", false));
        retorno.add(new PesoSexoIdade(PLUMA, INFANTO_JUVENIL_3, AMBOS, "45.999", "47.500", "48.300", false));
        retorno.add(new PesoSexoIdade(PLUMA, JUVENIL_1, MASCULINO, "50.999", null, "53.500", false));
        retorno.add(new PesoSexoIdade(PLUMA, JUVENIL_2, MASCULINO, "55.999", null, "58.500", false));
        retorno.add(new PesoSexoIdade(PLUMA, JUVENIL_1, FEMININO, "45.999", null, "48.300", false));
        retorno.add(new PesoSexoIdade(PLUMA, ADULTO, MASCULINO, "60.999", null, "64.000", false));
        retorno.add(new PesoSexoIdade(PLUMA, ADULTO, FEMININO, "50.999", null, "53.500", false));
        return retorno;
    }

    public List<PesoSexoIdade> pena() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(PENA, PRE_MIRIM_1, AMBOS, "15.999", "17.200", "18.000", false));
        retorno.add(new PesoSexoIdade(PENA, PRE_MIRIM_2, AMBOS, "17.999", "19.200", "20.000", false));
        retorno.add(new PesoSexoIdade(PENA, PRE_MIRIM_3, AMBOS, "19.999", "21.200", "22.000", false));
        retorno.add(new PesoSexoIdade(PENA, MIRIM_1, AMBOS, "21.999", "23.500", "24.000", false));
        retorno.add(new PesoSexoIdade(PENA, MIRIM_2, AMBOS, "24.999", "26.300", "27.000", false));
        retorno.add(new PesoSexoIdade(PENA, MIRIM_3, AMBOS, "27.999", "29.400", "30.200", false));
        retorno.add(new PesoSexoIdade(PENA, INFANTIL_1, AMBOS, "30.999", "32.400", "33.200", false));
        retorno.add(new PesoSexoIdade(PENA, INFANTIL_2, AMBOS, "33.999", "35.400", "36.200", false));
        retorno.add(new PesoSexoIdade(PENA, INFANTIL_3, AMBOS, "37.999", "39.500", "40.300", false));
        retorno.add(new PesoSexoIdade(PENA, INFANTO_JUVENIL_1, AMBOS, "41.999", "43.500", "44.300", false));
        retorno.add(new PesoSexoIdade(PENA, INFANTO_JUVENIL_2, AMBOS, "45.999", "47.500", "48.300", false));
        retorno.add(new PesoSexoIdade(PENA, INFANTO_JUVENIL_3, AMBOS, "49.999", "52.100", "52.500", false));
        retorno.add(new PesoSexoIdade(PENA, JUVENIL_1, MASCULINO, "55.999", null, "58.500", false));
        retorno.add(new PesoSexoIdade(PENA, JUVENIL_2, MASCULINO, "60.999", null, "64.000", false));
        retorno.add(new PesoSexoIdade(PENA, JUVENIL_1, FEMININO, "49.999", null, "52.500", false));
        retorno.add(new PesoSexoIdade(PENA, ADULTO, MASCULINO, "66.999", null, "70.000", false));
        retorno.add(new PesoSexoIdade(PENA, ADULTO, FEMININO, "55.999", null, "58.500", false));
        return retorno;
    }

    public List<PesoSexoIdade> leve() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(LEVE, PRE_MIRIM_1, AMBOS, "18.999", "20.200", "21.000", false));
        retorno.add(new PesoSexoIdade(LEVE, PRE_MIRIM_2, AMBOS, "20.999", "22.200", "24.000", false));
        retorno.add(new PesoSexoIdade(LEVE, PRE_MIRIM_3, AMBOS, "22.999", "24.300", "25.000", false));
        retorno.add(new PesoSexoIdade(LEVE, MIRIM_1, AMBOS, "24.999", "26.500", "27.000", false));
        retorno.add(new PesoSexoIdade(LEVE, MIRIM_2, AMBOS, "27.999", "29.400", "30.200", false));
        retorno.add(new PesoSexoIdade(LEVE, MIRIM_3, AMBOS, "30.999", "32.400", "33.200", false));
        retorno.add(new PesoSexoIdade(LEVE, INFANTIL_1, AMBOS, "33.999", "35.400", "36.200", false));
        retorno.add(new PesoSexoIdade(LEVE, INFANTIL_2, AMBOS, "36.999", "38.500", "39.300", false));
        retorno.add(new PesoSexoIdade(LEVE, INFANTIL_3, AMBOS, "41.999", "43.500", "44.300", false));
        retorno.add(new PesoSexoIdade(LEVE, INFANTO_JUVENIL_1, AMBOS, "45.999", "47.500", "48.300", false));
        retorno.add(new PesoSexoIdade(LEVE, INFANTO_JUVENIL_2, AMBOS, "49.999", "52.100", "52.500", false));
        retorno.add(new PesoSexoIdade(LEVE, INFANTO_JUVENIL_3, AMBOS, "53.999", "56.100", "56.500", false));
        retorno.add(new PesoSexoIdade(LEVE, JUVENIL_1, MASCULINO, "60.999", null, "64.000", false));
        retorno.add(new PesoSexoIdade(LEVE, JUVENIL_2, MASCULINO, "65.999", null, "69.000", false));
        retorno.add(new PesoSexoIdade(LEVE, JUVENIL_1, FEMININO, "53.999", null, "56.500", false));
        retorno.add(new PesoSexoIdade(LEVE, ADULTO, MASCULINO, "72.999", null, "76.000", true));
        retorno.add(new PesoSexoIdade(LEVE, ADULTO, FEMININO, "60.999", null, "64.000", true));
        return retorno;
    }

    public List<PesoSexoIdade> medio() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(MEDIO, PRE_MIRIM_1, AMBOS, "21.999", "23.200", "24.000", false));
        retorno.add(new PesoSexoIdade(MEDIO, PRE_MIRIM_2, AMBOS, "23.999", "25.300", "26.000", false));
        retorno.add(new PesoSexoIdade(MEDIO, PRE_MIRIM_3, AMBOS, "25.999", "27.300", "28.000", false));
        retorno.add(new PesoSexoIdade(MEDIO, MIRIM_1, AMBOS, "27.999", "29.500", "30.200", false));
        retorno.add(new PesoSexoIdade(MEDIO, MIRIM_2, AMBOS, "30.999", "32.400", "33.200", false));
        retorno.add(new PesoSexoIdade(MEDIO, MIRIM_3, AMBOS, "33.999", "35.400", "36.200", false));
        retorno.add(new PesoSexoIdade(MEDIO, INFANTIL_1, AMBOS, "36.999", "38.500", "39.300", false));
        retorno.add(new PesoSexoIdade(MEDIO, INFANTIL_2, AMBOS, "39.999", "41.500", "42.300", false));
        retorno.add(new PesoSexoIdade(MEDIO, INFANTIL_3, AMBOS, "45.999", "47.500", "48.300", false));
        retorno.add(new PesoSexoIdade(MEDIO, INFANTO_JUVENIL_1, AMBOS, "49.999", "52.100", "52.500", false));
        retorno.add(new PesoSexoIdade(MEDIO, INFANTO_JUVENIL_2, AMBOS, "53.999", "56.100", "56.500", false));
        retorno.add(new PesoSexoIdade(MEDIO, INFANTO_JUVENIL_3, AMBOS, "57.999", "60.100", "60.500", false));
        retorno.add(new PesoSexoIdade(MEDIO, JUVENIL_1, MASCULINO, "65.999", null, "69.000", false));
        retorno.add(new PesoSexoIdade(MEDIO, JUVENIL_2, MASCULINO, "70.999", null, "74.000", false)); //confirmar
        retorno.add(new PesoSexoIdade(MEDIO, JUVENIL_1, FEMININO, "57.999", null, "60.500", false)); //confirmar
        retorno.add(new PesoSexoIdade(MEDIO, ADULTO, MASCULINO, "78.999", null, "82.300", true));
        retorno.add(new PesoSexoIdade(MEDIO, ADULTO, FEMININO, "65.999", null, "69.000", true));
        return retorno;
    }

    public List<PesoSexoIdade> meioPesado() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(MEIO_PESADO, PRE_MIRIM_1, AMBOS, "24.999", "26.200", "27.000", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, PRE_MIRIM_2, AMBOS, "26.999", "28.300", "29.000", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, PRE_MIRIM_3, AMBOS, "28.999", "30.400", "31.200", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, MIRIM_1, AMBOS, "30.999", "32.500", "33.200", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, MIRIM_2, AMBOS, "33.999", "35.400", "36.200", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, MIRIM_3, AMBOS, "36.999", "38.500", "39.300", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, INFANTIL_1, AMBOS, "39.999", "41.500", "42.300", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, INFANTIL_2, AMBOS, "42.999", "44.500", "45.300", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, INFANTIL_3, AMBOS, "49.999", "52.100", "52.500", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, INFANTO_JUVENIL_1, AMBOS, "53.999", "56.100", "56.500", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, INFANTO_JUVENIL_2, AMBOS, "57.999", "60.100", "60.500", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, INFANTO_JUVENIL_3, AMBOS, "61.999", "64.200", "65.000", false));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, JUVENIL_1, MASCULINO, "70.999", null, "74.000", true));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, JUVENIL_2, MASCULINO, "75.999", null, "79.300", true));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, JUVENIL_1, FEMININO, "61.999", null, "65.000", true));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, ADULTO, MASCULINO, "84.999", null, "88.300", true));
        retorno.add(new PesoSexoIdade(MEIO_PESADO, ADULTO, FEMININO, "70.999", null, "74.000", true));
        return retorno;
    }

    public List<PesoSexoIdade> pesado() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(PESADO, PRE_MIRIM_1, AMBOS, "27.999", "29.300", "30.000", false));
        retorno.add(new PesoSexoIdade(PESADO, PRE_MIRIM_2, AMBOS, "29.999", "31.300", "32.000", false));
        retorno.add(new PesoSexoIdade(PESADO, PRE_MIRIM_3, AMBOS, "31.999", "33.400", "34.200", false));
        retorno.add(new PesoSexoIdade(PESADO, MIRIM_1, AMBOS, "33.999", "35.500", "36.200", false));
        retorno.add(new PesoSexoIdade(PESADO, MIRIM_2, AMBOS, "36.999", "38.500", "39.300", false));
        retorno.add(new PesoSexoIdade(PESADO, MIRIM_3, AMBOS, "39.999", "41.500", "42.300", false));
        retorno.add(new PesoSexoIdade(PESADO, INFANTIL_1, AMBOS, "42.999", "44.500", "45.300", false));
        retorno.add(new PesoSexoIdade(PESADO, INFANTIL_2, AMBOS, "45.999", "47.500", "48.300", false));
        retorno.add(new PesoSexoIdade(PESADO, INFANTIL_3, AMBOS, "53.999", "56.100", "56.500", false));
        retorno.add(new PesoSexoIdade(PESADO, INFANTO_JUVENIL_1, AMBOS, "57.999", "60.100", "60.500", false));
        retorno.add(new PesoSexoIdade(PESADO, INFANTO_JUVENIL_2, AMBOS, "61.999", "64.200", "65.000", false));
        retorno.add(new PesoSexoIdade(PESADO, INFANTO_JUVENIL_3, AMBOS, "65.999", "68.200", "69.000", false));
        retorno.add(new PesoSexoIdade(PESADO, JUVENIL_1, MASCULINO, "75.999", null, "79.300", true));
        retorno.add(new PesoSexoIdade(PESADO, JUVENIL_2, MASCULINO, "80.999", null, "84.300", true));
        retorno.add(new PesoSexoIdade(PESADO, JUVENIL_1, FEMININO, "65.999", null, "69.000", true));
        retorno.add(new PesoSexoIdade(PESADO, ADULTO, MASCULINO, "90.999", null, "94.300", true));
        retorno.add(new PesoSexoIdade(PESADO, ADULTO, FEMININO, "75.999", null, "79.300", true));
        return retorno;
    }

    public List<PesoSexoIdade> superPesado() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(SUPER_PESADO, PRE_MIRIM_1, AMBOS, "30.999", "32.300", "33.000", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, PRE_MIRIM_2, AMBOS, "32.999", "34.300", "35.000", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, PRE_MIRIM_3, AMBOS, "34.999", "36.400", "37.200", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, MIRIM_1, AMBOS, "36.999", "38.500", "39.300", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, MIRIM_2, AMBOS, "39.999", "41.500", "42.300", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, MIRIM_3, AMBOS, "42.999", "44.500", "45.300", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, INFANTIL_1, AMBOS, "45.999", "47.500", "48.300", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, INFANTIL_2, AMBOS, "48.999", "51.100", "51.500", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, INFANTIL_3, AMBOS, "57.999", "60.100", "60.500", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, INFANTO_JUVENIL_1, AMBOS, "61.999", "64.200", "65.000", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, INFANTO_JUVENIL_2, AMBOS, "65.999", "68.200", "69.000", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, INFANTO_JUVENIL_3, AMBOS, "69.999", "72.200", "73.000", false));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, JUVENIL_1, MASCULINO, "80.999", null, "84.300", true));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, JUVENIL_2, MASCULINO, "85.999", null, "89.300", true));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, JUVENIL_1, FEMININO, "69.999", null, "73.000", true));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, ADULTO, MASCULINO, "96.999", null, "100.500", true));
        retorno.add(new PesoSexoIdade(SUPER_PESADO, ADULTO, FEMININO, "80.999", null, "84.300", true));
        return retorno;
    }

    public List<PesoSexoIdade> pesadissimo() {
        List<PesoSexoIdade> retorno = new ArrayList<>();
        retorno.add(new PesoSexoIdade(PESADISSIMO, PRE_MIRIM_1, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, PRE_MIRIM_2, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, PRE_MIRIM_3, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, MIRIM_1, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, MIRIM_2, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, MIRIM_3, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, INFANTIL_1, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, INFANTIL_2, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, INFANTIL_3, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, INFANTO_JUVENIL_1, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, INFANTO_JUVENIL_2, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, INFANTO_JUVENIL_3, AMBOS, "999.000", "999.000", "999.000", false));
        retorno.add(new PesoSexoIdade(PESADISSIMO, JUVENIL_1, MASCULINO, "999.000", null, "999.000", true));
        retorno.add(new PesoSexoIdade(PESADISSIMO, JUVENIL_2, MASCULINO, "999.000", null, "999.000", true));
        retorno.add(new PesoSexoIdade(PESADISSIMO, JUVENIL_1, FEMININO, "999.000", null, "999.000", true));
        retorno.add(new PesoSexoIdade(PESADISSIMO, ADULTO, MASCULINO, "999.000", null, "999.000", true));
        retorno.add(new PesoSexoIdade(PESADISSIMO, ADULTO, FEMININO, "999.000", null, "999.000", true));
        return retorno;
    }

    public PesoSexoIdade recupera(CategoriaPeso categoriaPeso, CategoriaIdade categoriaIdade, Sexo sexo) {
        CategoriaIdade categoriaIdadeCalculada = calculaCategoriaIdade(categoriaIdade);
        if (sexo.equals(FEMININO) && categoriaIdade.equals(JUVENIL_2)) {
            categoriaIdadeCalculada = JUVENIL_1;
        }
        for (PesoSexoIdade psi : lista) {
            if (psi.getCategoriaPeso().equals(categoriaPeso) && psi.getCategoriaIdade().equals(categoriaIdadeCalculada) && (psi.getSexo().equals(sexo) || psi.getSexo().equals(AMBOS))) {
                return psi;
            }
        }
        System.out.println("Nenhum Registro Encontrado para PESO [" + categoriaPeso + "], IDADE [" + categoriaIdade + "] e SEXO [" + sexo + "]");
        return null;
    }

    private CategoriaIdade calculaCategoriaIdade(CategoriaIdade categoriaIdade) {
        if (categoriaIdade.equals(MASTER) || categoriaIdade.equals(SENIOR_1) || categoriaIdade.equals(SENIOR_2) || categoriaIdade.equals(SENIOR_3) || categoriaIdade.equals(SENIOR_4) || categoriaIdade.equals(SENIOR_5)) {
            return ADULTO;
        }
        return categoriaIdade;
    }

    public CategoriaPeso getCategoriaPesoPorIdadeSexoPeso(CategoriaIdade idade, Sexo sexo, TipoPeso tipoPeso, BigDecimal peso) {
        if (peso == null) {
            throw new IllegalArgumentException("Peso não pode ser Null");
        }
        List<PesoSexoIdade> listaIdadeSexo = new ArrayList<>();
        CategoriaIdade idadeCalculada = calculaCategoriaIdade(idade);
        if (sexo.equals(FEMININO) && idade.equals(JUVENIL_2)) {
            idadeCalculada = JUVENIL_1;
        }
        for (PesoSexoIdade psi : lista) {
            if (psi.getSexo().equals(sexo) && psi.getCategoriaIdade().equals(idadeCalculada)) {
                listaIdadeSexo.add(psi);
            }
        }
        Collections.sort(listaIdadeSexo);
        for (PesoSexoIdade psi : listaIdadeSexo) {
            if (peso.compareTo(getPeso(psi, tipoPeso)) < 0) {
                return psi.getCategoriaPeso();
            }
        }
        return CategoriaPeso.PESADISSIMO;
    }

    private BigDecimal getPeso(PesoSexoIdade psi, TipoPeso tipoPeso) {
        switch (tipoPeso) {
            case SEM_QUIMONO:
                return psi.getPesoSemQuimono();
            case QUIMONO_LISO:
                return psi.getPesoQuimonoLiso();
            case QUIMONO_TRANCADO:
                return psi.getPesoQuimonoTrancado();
        }
        return null;
    }

    public CategoriaIdade getCategoriaIdade(Date dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data não pode ser null");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataNascimento);
        int ano = cal.get(YEAR);
        return getCategoriaIdade(ano);
    }

    public CategoriaIdade getCategoriaIdade(int anoNascimento) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int anoAtual = cal.get(YEAR);
        int idade = anoAtual - anoNascimento;
        for (CategoriaIdade ci : CategoriaIdade.values()) {
            if (ci.getIdadeMinima() <= idade && ci.getIdadeMaxima() <= idade) {
                return ci;
            }
        }
        System.out.println("Não achou Categoria de Idade para a idade [" + idade + "] com Ano Nascimento [" + anoNascimento + "] e ano Atual [" + anoAtual + "]");
        return null;
    }
}

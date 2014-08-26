/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.negocios;

import br.com.techcode.entidades.PessoaFisica;
import br.com.techcode.supers.SuperFacade;
import br.com.techcode.util.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * @author AndreGustavo
 */
@Repository
public class PessoaFisicaFacade extends SuperFacade<PessoaFisica> {

    @PersistenceContext(unitName = Persistencia.UNIDADE_PERSISTENCIA)
    private EntityManager em;

    public PessoaFisicaFacade() {
        super(PessoaFisica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

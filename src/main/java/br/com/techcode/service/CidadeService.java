/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.service;

import br.com.techcode.entidades.Cidade;
import br.com.techcode.entidades.QCidade;
import br.com.techcode.entidades.QUsuario;
import br.com.techcode.entidades.Usuario;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Peixe
 */
@Service
public class CidadeService extends AbstractCadastroService<Cidade> {

    @Override
    public List<Cidade> findAll(Predicate predicate) {
        return new JPAQuery(entityManager).from(QCidade.cidade).where(predicate).list(QCidade.cidade);
    }

    @Override
    public Cidade findOne(Predicate predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cidade findOne(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cidade> findAll() {
         return new JPAQuery(entityManager).from(QCidade.cidade).list(QCidade.cidade);
    }
}

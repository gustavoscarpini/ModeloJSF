package br.com.bycodesign.negocios;

import br.com.bycodesign.entidades.Cidade;
import br.com.bycodesign.supers.SuperFacade;
import br.com.bycodesign.util.Persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CidadeFacade extends SuperFacade<Cidade> {

    @PersistenceContext(unitName = Persistencia.UNIDADE_PERSISTENCIA)
    private EntityManager em;

    public CidadeFacade() {
        super(Cidade.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    @Override
    public List<Cidade> listar() {
        String hql = "from Cidade e order by e.nome asc";
        Query q = getEntityManager().createQuery(hql);

        return q.getResultList();
    }
}

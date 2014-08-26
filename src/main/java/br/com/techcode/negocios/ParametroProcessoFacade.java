package br.com.techcode.negocios;

import br.com.techcode.entidades.ParametrosProcesso;
import br.com.techcode.supers.SuperFacade;
import br.com.techcode.util.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ParametroProcessoFacade extends SuperFacade<ParametrosProcesso> {

    @PersistenceContext(unitName = Persistencia.UNIDADE_PERSISTENCIA)
    private EntityManager em;

    public ParametroProcessoFacade() {
        super(ParametrosProcesso.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    @Override
    public List<ParametrosProcesso> listar() {
        String hql = "from ParametrosProcesso e order by e.nome asc";
        Query q = getEntityManager().createQuery(hql);

        return q.getResultList();
    }
}

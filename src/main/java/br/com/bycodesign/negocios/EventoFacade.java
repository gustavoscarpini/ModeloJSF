package br.com.bycodesign.negocios;

import br.com.bycodesign.entidades.Estado;
import br.com.bycodesign.entidades.Evento;
import br.com.bycodesign.entidades.Participante;
import br.com.bycodesign.supers.SuperFacade;
import br.com.bycodesign.util.Persistencia;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EventoFacade extends SuperFacade<Evento> {

    @PersistenceContext(unitName = Persistencia.UNIDADE_PERSISTENCIA)
    private EntityManager em;

    public EventoFacade() {
        super(Evento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    @Override
    public List<Evento> listar() {
        String hql = "from Evento e order by e.nome asc";
        Query q = getEntityManager().createQuery(hql);
        return q.getResultList();
    }

    public List<Participante> getParticipantes(Evento e){
        String hql = "from Participante e where e.evento = :evento order by e.nome asc";
        Query q = getEntityManager().createQuery(hql);
        q.setParameter("evento", e);
        return q.getResultList();
    }

}

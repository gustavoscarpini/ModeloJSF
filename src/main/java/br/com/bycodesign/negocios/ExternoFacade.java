package br.com.bycodesign.negocios;

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
public class ExternoFacade {

    @PersistenceContext(unitName = Persistencia.UNIDADE_PERSISTENCIA)
    private EntityManager em;

    @Transactional
    public void confirmaInscricao(Participante participante) {
        em.merge(participante);
    }
}

package br.com.techcode.service;

import br.com.techcode.entidades.GruposUsuario;
import br.com.techcode.entidades.QGruposUsuario;
import br.com.techcode.entidades.Usuario;
import br.com.techcode.supers.SuperFacade;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class GrupoUsuarioService extends SuperFacade<GruposUsuario> {

    @PersistenceContext(unitName = "eproconPU")
    private EntityManager entityManager;

    public GrupoUsuarioService() {
        super(GruposUsuario.class);
    }

    public List<GruposUsuario> findByUsuario(Usuario usuarioSistema) {
        QGruposUsuario qGruposUsuario = QGruposUsuario.gruposUsuario;
        return new JPAQuery(entityManager).from(qGruposUsuario).where(qGruposUsuario.usuario.eq(usuarioSistema)).list(qGruposUsuario);
    }

    public List<GruposUsuario> findAll(Predicate predicate) {
        return new JPAQuery(entityManager).from(QGruposUsuario.gruposUsuario).where(predicate)
                .list(QGruposUsuario.gruposUsuario);
    }

    public GruposUsuario findOne(Predicate predicate) {
        return new JPAQuery(entityManager).from(QGruposUsuario.gruposUsuario).where(predicate)
                .uniqueResult(QGruposUsuario.gruposUsuario);
    }

    public GruposUsuario findOne(Serializable id) {
        return entityManager.find(GruposUsuario.class, id);
    }

    @Override
    public long count() {
        return new JPAQuery(entityManager).from(QGruposUsuario.gruposUsuario).count();
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
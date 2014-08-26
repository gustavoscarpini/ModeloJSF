package br.com.techcode.service;

import br.com.techcode.entidades.GrupoRecurso;
import br.com.techcode.entidades.GruposUsuario;
import br.com.techcode.entidades.QGrupoRecurso;
import br.com.techcode.entidades.QGruposUsuario;
import br.com.techcode.entidades.RecursoSistema;
import br.com.techcode.supers.SuperFacade;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GrupoRecursoService extends SuperFacade<GrupoRecurso> {

    @PersistenceContext(unitName = "eproconPU")
    private EntityManager entityManager;

    public GrupoRecursoService() {
        super(GrupoRecurso.class);
    }

    public List<GrupoRecurso> findByUri(String uri) {
        JPQLQuery query = new JPAQuery(entityManager);
        QGrupoRecurso qGrupoRecurso = QGrupoRecurso.grupoRecurso;
//        QRecursoSistema qRecursoSistema = QRecursoSistema.recursoSistema;
//        return query.from(qGrupoRecurso).where(qGrupoRecurso.recursoSistema.eq(uri).or(qGrupoRecurso.recursoSistema.eq(extrairCaminhoAutorizacao(uri)))).listDistinct(qGrupoRecurso);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String extrairCaminhoAutorizacao(String uri) {
        return uri.substring(0, uri.lastIndexOf('/'));
    }

//    @Override
    public List<GrupoRecurso> findAll(Predicate predicate) {
        return new JPAQuery(entityManager).from(QGrupoRecurso.grupoRecurso).where(predicate).list(QGrupoRecurso.grupoRecurso);
    }

//    @Override
    public GrupoRecurso findOne(Predicate predicate) {
        return new JPAQuery(entityManager).from(QGrupoRecurso.grupoRecurso).where(predicate).uniqueResult(QGrupoRecurso.grupoRecurso);
    }

//    @Override
    public GrupoRecurso findOne(Serializable id) {
        return entityManager.find(GrupoRecurso.class, id);
    }

    @Override
    public long count() {
        return new JPAQuery(entityManager).from(QGrupoRecurso.grupoRecurso).count();
    }

    public boolean listaGrupoRecursosUsuario(GruposUsuario gru, RecursoSistema recursoSistema) {
        Query q = entityManager.createQuery(" from Grupo gru join gru.grupoRecursos rec join gru.gruposUsuarios use  "
                + " where use = :gu and rec.recursoSistema = :recurso");
        q.setParameter("gu", gru);
        q.setParameter("recurso", recursoSistema);
        return !q.getResultList().isEmpty();
//        QGrupoRecurso qGrupoRecurso = QGrupoRecurso.grupoRecurso;
//        return new JPAQuery(entityManager).from(QGruposUsuario.gruposUsuario).where(QGruposUsuario.gruposUsuario.grupo.eq(gru.getGrupo()).and(qGrupoRecurso.recursoSistema.eq(recursoSistema))).exists();
    }

//    @Override
    public List<GrupoRecurso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public GrupoRecurso save(GrupoRecurso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public GrupoRecurso remove(GrupoRecurso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
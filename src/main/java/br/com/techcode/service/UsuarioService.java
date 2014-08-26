/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.service;

import br.com.techcode.entidades.QUsuario;
import br.com.techcode.entidades.RecursoSistema;
import br.com.techcode.entidades.Usuario;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author Peixe
 */
@Service
public class UsuarioService extends AbstractCadastroService<Usuario> {

    @Override
    public List<Usuario> findAll(Predicate predicate) {
        return new JPAQuery(entityManager).from(QUsuario.usuario).where(predicate).list(QUsuario.usuario);
    }

    @Override
    public Usuario findOne(Predicate predicate) {
        return new JPAQuery(entityManager).from(QUsuario.usuario).where(predicate).uniqueResult(QUsuario.usuario);
    }

    @Override
    public Usuario findOne(Serializable id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public long count() {
        return new JPAQuery(entityManager).from(QUsuario.usuario).count();
    }

    public List<RecursoSistema> listaRecursosUsuario(Usuario usuario) {
        String hql = "from Grupo ru where ru.usuario = :usuario";
        Query q = entityManager.createQuery(hql);
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }

    /**
     * tem que fazer refactory
     *
     * @param usuario
     * @param recursoSistema
     * @return
     */
    public RecursoSistema listaRecursosUsuarioRecurso(Usuario usuario, RecursoSistema recursoSistema) {

        StringBuilder hql = new StringBuilder();
        hql.append("select ru from GrupoRecurso ru ");
        hql.append(" inner join ru.recursoSistema rs ");
        hql.append(" where ru.usuario = :usuario ");
        hql.append(" and rs = :recursoSistema");
        Query q = entityManager.createQuery(hql.toString());
        q.setParameter("usuario", usuario);
        q.setParameter("grupo", recursoSistema);
        List<RecursoSistema> lista = q.getResultList();
        if (!lista.isEmpty()) {
            return (RecursoSistema) lista.get(0);
        }
        return null;
    }

    /**
     * Método utilizado para recuperar todos os recursos do sistema declarados
     * diretamente para um usuário
     *
     * @param us Usuário para o qual se deseja recuperar todos os recursos do
     * sistema
     * @return Lista de urls para os quais determinado usuário possui acesso
     */
    public List<String> getRecursosSistemaDiretosDoUsuario(Usuario us) {
        String hql = " select distinct rs.caminho from RecursosUsuario ru"
                + "  inner join ru.recursoSistema rs"
                + "  where ru.usuario = :usuario"
                + "    and ru.leitura is true";

        Query q = entityManager.createQuery(hql);
        q.setParameter("usuario", us);
        return q.getResultList();
    }

    /**
     * Método utilizado para recuperar todos os recursos do sistema atribuidos
     * pelo grupo de recursos
     *
     * @param us Usuário para o qual se deseja recuperar todos os recursos do
     * sistema
     * @return Lista de urls para os quais determinado usuário possui acesso
     */
    public List<String> getRecursosSistemaDosGruposDeRecursoDoUsuario(Usuario us) {
        String hql = " select distinct rs.caminho from GrupoRecursosUsuario gru"
                + "  inner join gru.grupoRecurso.recursos rs"
                + "  where gru.usuario = :usuario"
                + "    and gru.leitura is true";

        Query q = entityManager.createQuery(hql);
        q.setParameter("usuario", us);
        return q.getResultList();
    }

    /**
     * Método utilizado para recuperar todos os recursos do sistema atribuidos
     * pelo grupo de usuários
     *
     * @param us Usuário para o qual se deseja recuperar todos os recursos do
     * sistema
     * @return Lista de urls para os quais determinado usuário possui acesso
     */
    public List<String> getRecursosSistemaDosGruposDeUsuariosDoUsuario(Usuario us) {
        String hql = " select distinct rs.caminho from GrupoUsuario gu"
                + "  inner join gu.usuarios usu"
                + "  inner join gu.itens it"
                + "  inner join it.grupoRecurso.recursos rs"
                + "  where usu = :usuario"
                + "    and it.leitura is true";

        Query q = entityManager.createQuery(hql);
        q.setParameter("usuario", us);
        return q.getResultList();
    }

    @Override
    public List<Usuario> findAll() {
        return new JPAQuery().from(QUsuario.usuario).list(QUsuario.usuario);
    }

    @Override
    public Usuario save(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario remove(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

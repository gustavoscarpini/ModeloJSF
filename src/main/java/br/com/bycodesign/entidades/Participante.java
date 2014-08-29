package br.com.bycodesign.entidades;

import br.com.bycodesign.util.Cadastravel;
import br.com.bycodesign.util.Validacao;
import br.com.bycodesign.util.anotacoes.CRUD;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Audited
@CRUD(label="Estado")
public class Participante implements Serializable, Cadastravel {

    private static final long serialVersionUID = 1L;
    @Id
    @CRUD(visualizavel = true, label = "Código", obrigatorio = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CRUD(visualizavel = true, label = "Nome")
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @CRUD(visualizavel = true, label = "Evento")
    @ManyToOne
    private Evento evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome ;
    }

    @Override
    public String getCaminhoPadrao() {
        return "/cadastro/estado/";
    }

    @Override
    public Validacao executaValidacao() {
        Validacao validacao = Validacao.newValidacao();
        if (this.getNome() != null && this.getNome().length() < 2) {
            validacao.addMensagem("Informação inválida", "O campo Nome deve conter pelo menos dois caracteres");
        }
        return validacao;
    }

}

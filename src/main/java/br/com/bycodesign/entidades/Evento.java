package br.com.bycodesign.entidades;

import br.com.bycodesign.util.Cadastravel;
import br.com.bycodesign.util.Validacao;
import br.com.bycodesign.util.anotacoes.CRUD;
import com.google.common.collect.Lists;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Audited
@CRUD(label = "Evento")
public class Evento implements Serializable, Cadastravel {

    private static final long serialVersionUID = 1L;
    @Id
    @CRUD(visualizavel = true, label = "Código", obrigatorio = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CRUD(visualizavel = true, label = "Nome")
    private String nome;
    @CRUD(visualizavel = true, label = "Número de Vagas")
    private Integer vagas;
    @CRUD(visualizavel = true, label = "Data para Início das Inscrições")
    private Date inicioInscricoes;
    @CRUD(visualizavel = true, label = "Data para Fim das Inscrições")
    private Date finalInscricoes;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DataEvento> datas;

    public Evento() {
        datas = Lists.newArrayList();
    }

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

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<DataEvento> getDatas() {
        return datas;
    }

    public void addData(DataEvento dataEvento) {
        this.datas.add(dataEvento);
    }

    public void removeData(DataEvento dataEvento) {
        this.datas.remove(dataEvento);
    }

    public Date getInicioInscricoes() {
        return inicioInscricoes;
    }

    public void setInicioInscricoes(Date inicioInscricoes) {
        this.inicioInscricoes = inicioInscricoes;
    }

    public Date getFinalInscricoes() {
        return finalInscricoes;
    }

    public void setFinalInscricoes(Date finalInscricoes) {
        this.finalInscricoes = finalInscricoes;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public String getCaminhoPadrao() {
        return "/cadastro/evento/";
    }

    @Override
    public Validacao executaValidacao() {
        Validacao validacao = Validacao.newValidacao();
        if (this.getNome() != null && this.getNome().length() < 2) {
            validacao.addMensagem("Informação inválida", "O campo Nome deve conter dois ou mais caracteres");
        }
        return validacao;
    }
}

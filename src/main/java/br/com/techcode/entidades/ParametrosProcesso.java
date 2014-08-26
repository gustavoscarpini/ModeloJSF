package br.com.techcode.entidades;

import br.com.techcode.util.Cadastravel;
import br.com.techcode.util.Validacao;
import br.com.techcode.util.anotacoes.CRUD;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class ParametrosProcesso implements Serializable, Cadastravel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CRUD(label = "Descrição")
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    @CRUD(label = "Inicio da Vigência", obrigatorio=false)
    private Date inicioVigencia;
    @Temporal(javax.persistence.TemporalType.DATE)
    @CRUD(label = "Final da Vigência", obrigatorio=false)
    private Date finalVigencia;
    @CRUD(label = "Código")
    private String codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFinalVigencia() {
        return finalVigencia;
    }

    public void setFinalVigencia(Date finalVigencia) {
        this.finalVigencia = finalVigencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return Objects.equals(object, this);
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.ParametrosProcesso[ id=" + id + " ]";
    }

    @Override
    public String getCaminhoPadrao() {
        return "/configuracao/parametros/";
    }

    @Override
    public Validacao executaValidacao() {
        Validacao validacao = Validacao.newValidacao();
        if (this.getDescricao() != null && this.getDescricao().length() < 3) {
            validacao.addMensagem("Informação inválida", "O campo descrição deve conter três ou mais caracteres");
        }
        return validacao;
    }
}

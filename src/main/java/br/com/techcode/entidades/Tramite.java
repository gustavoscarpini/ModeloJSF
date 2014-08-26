package br.com.techcode.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Processo processo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    private String observacao;
    private Integer prazo;
    @Enumerated(EnumType.STRING)
    private TipoTramite tipoTramite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isVencido() {
        if (prazo == null) {
            Calendar vencimento = Calendar.getInstance();
            vencimento.setTime(inicio);
            vencimento.add(Calendar.DAY_OF_MONTH, prazo);
            return inicio.before(vencimento.getTime());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    @Override
    public boolean equals(Object object) {
        return Objects.equals(object, this);
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.Tramite[ id=" + id + " ]";
    }

    public enum TipoTramite {

        JUNTADA_DOCUMENTOS, NOTIFICACAO_RECLAMADO;
    }
}

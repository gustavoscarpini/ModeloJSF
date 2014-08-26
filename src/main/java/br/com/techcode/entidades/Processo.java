package br.com.techcode.entidades;

import br.com.techcode.util.anotacoes.CRUD;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    @CRUD(label="Início")
    private Date inicio;
    @CRUD(label="Número")
    private Integer numero;
    @Lob
    private String reclamacao;
    @ManyToOne
    @CRUD(label="Parâmentro")
    private ParametrosProcesso parametro;
    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reclamente> reclamentes;
    @OneToMany(mappedBy="processo", cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Reclamado> reclamados;
    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tramite> tramites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reclamente> getReclamentes() {
        return reclamentes;
    }

    public List<Reclamado> getReclamados() {
        return reclamados;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public ParametrosProcesso getParametro() {
        return parametro;
    }

    public void setParametro(ParametrosProcesso parametro) {
        this.parametro = parametro;
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
        return "br.com.techcode.entidades.Processo[ id=" + id + " ]";
    }
}

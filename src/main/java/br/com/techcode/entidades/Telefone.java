/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.entidades;

import br.com.techcode.enums.TipoTelefone;
import br.com.techcode.util.IdentidadeEntidade;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.hibernate.envers.Audited;

/**
 *
 * @author AndreGustavo
 */
@Entity
@Audited
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero;
    private TipoTelefone tipoTelefone;
    @ManyToOne
    private Pessoa pessoa;
    @Transient
    private Long criadoEm;

    public Telefone() {
        criadoEm = System.nanoTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Long criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        return IdentidadeEntidade.calcularEquals(this, object);
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.Telefone[ id=" + id + " ]";
    }
}

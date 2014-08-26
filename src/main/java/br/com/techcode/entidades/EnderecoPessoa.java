package br.com.techcode.entidades;

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
public class EnderecoPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Pessoa pessoa;
    @ManyToOne
    private EnderecoCorreio enderecoCorreio;
    @Transient
    private Long criadoEm;

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public EnderecoCorreio getEnderecoCorreio() {
        return enderecoCorreio;
    }

    public void setEnderecoCorreio(EnderecoCorreio enderecoCorreio) {
        this.enderecoCorreio = enderecoCorreio;
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
        return "br.com.techcode.entidades.Endereco[ id=" + id + " ]";
    }
}

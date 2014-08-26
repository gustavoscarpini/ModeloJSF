package br.com.techcode.entidades;

import br.com.techcode.enums.TipoEmpresa;
import br.com.techcode.util.Cadastravel;
import br.com.techcode.util.Validacao;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.hibernate.envers.Audited;

/**
 *
 * @author AndreGustavo
 */
@Entity
@Audited
public class PessoaJuridica extends Pessoa implements Serializable, Cadastravel {

    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    public String getNome() {
        return nomeFantasia;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpfCnpj() {
        return cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.PessoaJuridica[ id=" + getId() + " ]";
    }

    @Override
    public String getCaminhoPadrao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Validacao executaValidacao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

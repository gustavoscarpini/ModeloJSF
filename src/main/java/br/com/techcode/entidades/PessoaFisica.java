package br.com.techcode.entidades;

import br.com.techcode.util.Cadastravel;
import br.com.techcode.util.FacesUtil;
import br.com.techcode.util.Util;
import br.com.techcode.util.Validacao;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

/**
 *
 * @author AndreGustavo
 */
@Entity
@Audited
public class PessoaFisica extends Pessoa implements Serializable, Cadastravel {

    private String nome;
    private String cpf;
    private String rg;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCpfCnpj() {
        return cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.PessoaFisica[ id=" + getId() + " ]";
    }

    @Override
    public String getCaminhoPadrao() {
        return "/cadastros/pessoa-fisica/";
    }

    @Override
    public Validacao executaValidacao() {
        Validacao validacao = Validacao.newValidacao();
        if (!Util.valida_CpfCnpj(getCpf())) {
            validacao.addMensagem("Atenção!", "O CPF : " + getCpf() + " não é válido.");
            return Validacao.newValidacao();
        }
        return validacao;
    }
}
package br.com.techcode.entidades;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AndreGustavo
 */
@Entity
@Audited
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoPessoa> enderecos;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArquivoPessoa> arquivosPessoa;
    private String eMail;
    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;

    public Pessoa() {
        telefones = new ArrayList<>();
        eMail = "";
        enderecos = new ArrayList<>();
        arquivosPessoa = new ArrayList<>();
    }

    public abstract String getNome();

    public abstract String getCpfCnpj();

    public List<EnderecoPessoa> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoPessoa> enderecos) {
        this.enderecos = enderecos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public List<ArquivoPessoa> getArquivosPessoa() {
        return arquivosPessoa;
    }

    public void setArquivosPessoa(List<ArquivoPessoa> arquivosPessoa) {
        this.arquivosPessoa = arquivosPessoa;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.Pessoa[ id=" + id + " ]";
    }
}

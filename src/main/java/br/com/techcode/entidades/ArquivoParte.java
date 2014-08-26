
package br.com.techcode.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import org.hibernate.envers.Audited;

/**
 *
 * @author AndreGustavo
 */
@Entity
@Audited
public class ArquivoParte implements Serializable {

    public static final int TAMANHO_MAXIMO = 4096;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    @Column(length = TAMANHO_MAXIMO)
    private byte dados[];
    @ManyToOne
    private Arquivo arquivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
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
        if (!(object instanceof ArquivoParte)) {
            return false;
        }
        ArquivoParte other = (ArquivoParte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.techcode.entidades.ArquivoParte[ id=" + id + " ]";
    }
}

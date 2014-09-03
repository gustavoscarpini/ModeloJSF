package br.com.bycodesign.entidades;

import br.com.bycodesign.util.Cadastravel;
import br.com.bycodesign.util.FacesUtil;
import br.com.bycodesign.util.Validacao;
import br.com.bycodesign.util.anotacoes.CRUD;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Audited
public class DataEvento implements Serializable, Cadastravel {

    private static final long serialVersionUID = 1L;
    @Id
    @CRUD(visualizavel = true, label = "Código", obrigatorio = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @ManyToOne
    private Evento evento;

    @Override
    public String getCaminhoPadrao() {
        return null;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataEvento)) return false;

        DataEvento that = (DataEvento) o;

        if (dia != null ? !dia.equals(that.dia) : that.dia != null) return false;
        if (horaFim != null ? !horaFim.equals(that.horaFim) : that.horaFim != null) return false;
        if (horaInicio != null ? !horaInicio.equals(that.horaInicio) : that.horaInicio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dia != null ? dia.hashCode() : 0;
        result = 31 * result + (horaInicio != null ? horaInicio.hashCode() : 0);
        result = 31 * result + (horaFim != null ? horaFim.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataEvento{" +
                "id=" + id +
                ", dia=" + dia +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }

    @Override
    public Validacao executaValidacao() {
        Validacao validacao = Validacao.newValidacao();
        if (getDia() == null) {
            validacao.addMensagem("Campo obrigatório.", "Informe o dia do evento.");
        }
        if (getHoraInicio() == null) {
            validacao.addMensagem("Campo obrigatório.", "Informe a hora inicial do evento.");
        }
        if (getHoraFim() == null) {
            validacao.addMensagem("Campo obrigatório.", "Informe a hora final do evento.");
        }
        if (getHoraInicio() != null && getHoraFim() != null && getHoraFim().before(getHoraInicio())) {
            validacao.addMensagem("Operação não permitida.", "A hora final deve ser maior que a hora inicial.");

        }
        return validacao;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bycodesign.controladores;

import br.com.bycodesign.entidades.Evento;
import br.com.bycodesign.entidades.Participante;
import br.com.bycodesign.negocios.EventoFacade;
import br.com.bycodesign.negocios.ExternoFacade;
import br.com.bycodesign.util.FacesUtil;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.Serializable;


@ManagedBean(name = "externoControlador")
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "home-externo", pattern = "/home/", viewId = "/faces/externo/index.xhtml"),
        @URLMapping(id = "inscricao", pattern = "/inscricao/#{externoControlador.idEvento}/", viewId = "/faces/externo/inscricao.xhtml")
})
public class ExternoControlador implements Serializable {


    @Autowired
    private EventoFacade eventoFacade;
    @Autowired
    private ExternoFacade externoFacade;
    private Long idEvento;
    private Participante participante;

    public ExternoControlador() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletContext);
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    @URLAction(mappingId = "inscricao", phaseId = URLAction.PhaseId.RENDER_RESPONSE, onPostback = false)
    public void inscricao() {
        participante = new Participante();
        System.out.println("evento " + idEvento);
        participante.setEvento(eventoFacade.recuperar(idEvento));
    }

    public void confirmaInscricao() {
        externoFacade.confirmaInscricao(participante);
        FacesUtil.redirecionamentoInterno("/home/");
        FacesUtil.addInfo("Belezura", "Você foi inscrito com sucesso no evento " + participante.getEvento().getNome() + " as informações estão no seu email. confere lá!");
    }

}

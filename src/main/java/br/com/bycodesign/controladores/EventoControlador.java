/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bycodesign.controladores;

import br.com.bycodesign.entidades.DataEvento;
import br.com.bycodesign.entidades.Estado;
import br.com.bycodesign.entidades.Evento;
import br.com.bycodesign.entidades.Participante;
import br.com.bycodesign.negocios.EstadoFacade;
import br.com.bycodesign.negocios.EventoFacade;
import br.com.bycodesign.supers.SuperControlador;
import br.com.bycodesign.supers.SuperFacade;
import br.com.bycodesign.util.FacesUtil;
import br.com.bycodesign.util.Validacao;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLAction.PhaseId;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Felipe Marinzeck
 */
@ManagedBean(name = "eventoControlador")
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "novo-evento", pattern = "/cadastro/evento/novo/", viewId = "/faces/interno/cadastro/evento/editar.xhtml"),
        @URLMapping(id = "editar-evento", pattern = "/cadastro/evento/editar/#{eventoControlador.id}/", viewId = "/faces/interno/cadastro/evento/editar.xhtml"),
        @URLMapping(id = "listar-evento", pattern = "/cadastro/evento/listar/", viewId = "/faces/interno/cadastro/evento/listar.xhtml"),
        @URLMapping(id = "ver-evento", pattern = "/cadastro/evento/ver/#{eventoControlador.id}/", viewId = "/faces/interno/cadastro/evento/visualizar.xhtml")
})
public class EventoControlador extends SuperControlador<Evento> implements Serializable {


    @Autowired
    private EventoFacade eventoFacade;
    private List<Participante> participantes;
    private DataEvento dataEvento;

    public EventoControlador() {
        super(Evento.class);
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public SuperFacade getEsteFacade() {
        return eventoFacade;
    }

    @URLAction(mappingId = "listar-evento", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void listar() {
        super.listar();
    }

    @URLAction(mappingId = "novo-evento", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void novo() {
        super.novo();
        dataEvento = new DataEvento();
    }

    @URLAction(mappingId = "editar-evento", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void editar() {
        super.editar();
        dataEvento = new DataEvento();
    }

    @URLAction(mappingId = "ver-evento", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void visualizar() {
        super.visualizar();
    }

    public void carregaParticipantes() {
        participantes = eventoFacade.getParticipantes(selecionado);
    }

    public DataEvento getDataEvento() {
        return dataEvento;
    }

    public void addDataEvento() {
        Validacao validacao = dataEvento.executaValidacao();
        if (validacao.isValido()) {
            dataEvento.setEvento(selecionado);
            selecionado.addData(dataEvento);
            dataEvento = new DataEvento();
        } else {
            FacesUtil.addAll(validacao.getFacesMensages());
        }
    }

    public void removeDataEvento(DataEvento dataEvento) {
        selecionado.removeData(dataEvento);
    }
}

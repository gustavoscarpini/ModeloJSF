/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bycodesign.controladores;

import br.com.bycodesign.entidades.Estado;
import br.com.bycodesign.entidades.Evento;
import br.com.bycodesign.negocios.EstadoFacade;
import br.com.bycodesign.negocios.EventoFacade;
import br.com.bycodesign.supers.SuperControlador;
import br.com.bycodesign.supers.SuperFacade;
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

    public EventoControlador() {
        super(Evento.class);
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
    }

    @URLAction(mappingId = "editar-evento", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void editar() {
        super.editar();
    }

    @URLAction(mappingId = "ver-evento", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void visualizar() {
        super.visualizar();
    }

}

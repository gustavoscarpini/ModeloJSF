/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.controladores;

import br.com.techcode.entidades.ParametrosProcesso;
import br.com.techcode.negocios.ParametroProcessoFacade;
import br.com.techcode.supers.SuperControlador;
import br.com.techcode.supers.SuperFacade;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLAction.PhaseId;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "parametroControlador")
@ViewScoped
@URLMappings(mappings = {
    @URLMapping(id = "novo-parametro", pattern = "/configuracao/parametros/criar/", viewId = "/faces/configuracao/parametros/editar.xhtml"),
    @URLMapping(id = "editar-parametro", pattern = "/configuracao/parametros/editar/#{parametroControlador.id}/", viewId = "/faces/configuracao/parametros/editar.xhtml"),
    @URLMapping(id = "listar-parametro", pattern = "/configuracao/parametros/listar/", viewId = "/faces/configuracao/parametros/listar.xhtml"),
    @URLMapping(id = "ver-parametro", pattern = "/configuracao/parametros/ver/#{parametroControlador.id}/", viewId = "/faces/configuracao/parametros/visualizar.xhtml")
})
public class ParametroProcessoControlador extends SuperControlador<ParametrosProcesso> implements Serializable {

    @Autowired
    private ParametroProcessoFacade parametroFacade;


    public ParametroProcessoControlador() {
        super(ParametrosProcesso.class);
    }


    @Override
    public SuperFacade getEsteFacade() {
        return parametroFacade;
    }

    @URLAction(mappingId = "listar-parametro", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void listar() {
        super.listar();
    }

    @URLAction(mappingId = "novo-parametro", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void novo() {
        super.novo();
    }

    @URLAction(mappingId = "editar-parametro", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void editar() {
        super.editar();
    }

    @URLAction(mappingId = "ver-parametro", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void visualizar() {
        super.visualizar();
    }  

    public List<ParametrosProcesso> completarEstaEntidade(String parte) {
        return parametroFacade.listarFiltrando(parte.trim(), "titulo", "id");
    }

    public List<SelectItem> selectItensParametrosProcesso() {
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        toReturn.add(new SelectItem(null, " "));
        for (ParametrosProcesso catDaVez : parametroFacade.listar()) {
            toReturn.add(new SelectItem(catDaVez.getId(), catDaVez.toString()));
        }
        return toReturn;
    }
}

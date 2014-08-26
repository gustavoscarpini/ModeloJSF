/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.controladores;

import br.com.techcode.entidades.ParametrosProcesso;
import br.com.techcode.entidades.Pessoa;
import br.com.techcode.entidades.PessoaFisica;
import br.com.techcode.entidades.PessoaJuridica;
import br.com.techcode.entidades.Processo;
import br.com.techcode.negocios.ProcessoFacade;
import br.com.techcode.supers.SuperControlador;
import br.com.techcode.supers.SuperFacade;
import com.google.common.collect.Lists;
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

@ManagedBean(name = "processoControlador")
@ViewScoped
@URLMappings(mappings = {
    @URLMapping(id = "novo-processo", pattern = "/processo/criar/", viewId = "/faces/processo/editar.xhtml"),
    @URLMapping(id = "editar-processo", pattern = "/processo/editar/#{processoControlador.id}/", viewId = "/faces/processo/editar.xhtml"),
    @URLMapping(id = "listar-processo", pattern = "/processo/listar/", viewId = "/faces/processo/listar.xhtml"),
    @URLMapping(id = "ver-processo", pattern = "/processo/ver/#{processoControlador.id}/", viewId = "/faces/processo/visualizar.xhtml")
})
public class ProcessoControlador extends SuperControlador<Processo> implements Serializable {

    @Autowired
    private ProcessoFacade processoFacade;

    public ProcessoControlador() {
        super(Processo.class);
    }

    @Override
    public SuperFacade getEsteFacade() {
        return processoFacade;
    }

    @URLAction(mappingId = "listar-processo", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void listar() {
        super.listar();
    }

    @URLAction(mappingId = "novo-processo", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void novo() {
        super.novo();
    }

    @URLAction(mappingId = "editar-processo", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void editar() {
        super.editar();
    }

    @URLAction(mappingId = "ver-processo", phaseId = PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void visualizar() {
        super.visualizar();
    }

    public List<Processo> completarEstaEntidade(String parte) {
        return processoFacade.listarFiltrando(parte.trim(), "titulo", "id");
    }

    public List<SelectItem> selectItensParametrosProcesso() {
        List<SelectItem> toReturn = new ArrayList<>();
        toReturn.add(new SelectItem(null, " "));
        for (Processo catDaVez : processoFacade.listar()) {
            toReturn.add(new SelectItem(catDaVez.getId(), catDaVez.toString()));
        }
        return toReturn;
    }

    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = Lists.newLinkedList();
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Mailson Peixe");
        pf.setCpf("1232133131312");
        pessoas.add(pf);
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNomeFantasia("Mailson Hotel");
        pj.setRazaoSocial("Mailson Peixe Hotelaria");
        pj.setCnpj("2321312312132");
        pessoas.add(pj);
        return pessoas;
    }
}

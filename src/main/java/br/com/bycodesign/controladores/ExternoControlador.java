/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bycodesign.controladores;

import br.com.bycodesign.negocios.EventoFacade;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;


@ManagedBean(name = "estadoControlador")
@ViewScoped
@URLMappings(mappings = {
    @URLMapping(id = "home-externo", pattern = "/externo/home/", viewId = "/faces/externo/index.xhtml")
})
public class ExternoControlador implements Serializable {


    @Autowired
    private EventoFacade eventoFacade;


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.controladores;

import br.com.techcode.entidades.*;
import br.com.techcode.enums.TipoArquivo;
import br.com.techcode.enums.TipoEndereco;
import br.com.techcode.enums.TipoTelefone;
import br.com.techcode.negocios.PessoaFisicaFacade;
import br.com.techcode.supers.SuperControlador;
import br.com.techcode.supers.SuperFacade;
import br.com.techcode.util.FacesUtil;
import br.com.techcode.util.Util;
import br.com.techcode.util.anotacoes.Operacoes;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AndreGustavo
 */
@ManagedBean(name = "pessoaFisicaControlador")
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "criar-pessoa-fisica", pattern = "/cadastros/pessoa-fisica/criar/", viewId = "/faces/cadastro/pessoa/pessoafisica/editar.xhtml"),
        @URLMapping(id = "editar-pessoa-fisica", pattern = "/cadastros/pessoa-fisica/editar/#{pessoaFisicaControlador.id}/", viewId = "/faces/cadastro/pessoa/pessoafisica/editar.xhtml"),
        @URLMapping(id = "listar-pessoa-fisica", pattern = "/cadastros/pessoa-fisica/listar/", viewId = "/faces/cadastro/pessoa/pessoafisica/listar.xhtml"),
        @URLMapping(id = "ver-pessoa-fisica", pattern = "/cadastros/pessoa-fisica/listar/#{pessoaFisicaControlador.id}/", viewId = "/faces/cadastro/pessoa/pessoafisica/visualizar.xhtml")
})
public class PessoaFisicaControlador extends SuperControlador<PessoaFisica> implements Serializable {

    @Autowired
    private PessoaFisicaFacade pessoaFisicaFacade;
    private FileUploadEvent fileUploadEvent;
    private StreamedContent imagemFoto;
    private Arquivo arquivo;
    private List<EnderecoPessoa> listaEderecoPessoa;
    private EnderecoCorreio endereco;
    private List<Telefone> listaTelefones;
    private Telefone telefone;

    public PessoaFisicaControlador() {
        super(PessoaFisica.class);
    }

    @URLAction(mappingId = "criar-pessoa-fisica", phaseId = URLAction.PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void novo() {
        setOperacao(Operacoes.NOVO);
        selecionado = new PessoaFisica();
        arquivo = new Arquivo();
        listaEderecoPessoa = new ArrayList<>();
        endereco = new EnderecoCorreio();
        listaTelefones = new ArrayList<>();
        telefone = new Telefone();
    }

    @URLAction(mappingId = "editar-pessoa-fisica", phaseId = URLAction.PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void editar() {
        super.editar();
    }

    @URLAction(mappingId = "listar-pessoa-fisica", phaseId = URLAction.PhaseId.RENDER_RESPONSE, onPostback = false)
    @Override
    public void listar() {
        super.listar();
    }

    @Override
    public void salvar() {
        ((PessoaFisica) selecionado).setEnderecos(listaEderecoPessoa);
        ((PessoaFisica) selecionado).setTelefones(listaTelefones);
        if (validaPessoa()) {
            System.out.println("Vai salvar");
            super.salvar();
        }
    }

    public boolean validaCPF() {
        if (!Util.valida_CpfCnpj(((PessoaFisica) selecionado).getCpf())) {
            FacesUtil.addWarn("Atenção!", "O CPF : " + ((PessoaFisica) selecionado).getCpf() + " não é válido.");
            return false;
        }
        return true;
    }

    public List<EnderecoPessoa> getListaEderecoPessoa() {
        return listaEderecoPessoa;
    }

    public void setListaEderecoPessoa(List<EnderecoPessoa> listaEderecoPessoa) {
        this.listaEderecoPessoa = listaEderecoPessoa;
    }

    public EnderecoCorreio getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCorreio endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<Telefone> listaTelefones) {
        this.listaTelefones = listaTelefones;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public FileUploadEvent getFileUploadEvent() {
        return fileUploadEvent;
    }

    public void setFileUploadEvent(FileUploadEvent fileUploadEvent) {
        this.fileUploadEvent = fileUploadEvent;
    }

    public StreamedContent getImagemFoto() {
        return imagemFoto;
    }

    public void setImagemFoto(StreamedContent imagemFoto) {
        this.imagemFoto = imagemFoto;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public void uploadArquivo(FileUploadEvent evt) {
        try {
            fileUploadEvent = evt;
            if (validaFotoPessoa()) {
                adicionaFotoPessoa(evt);
            }
            System.out.println("evt --- " + fileUploadEvent);
            System.out.println("file --- " + fileUploadEvent.getFile());
            System.out.println("input --- " + fileUploadEvent.getFile().getInputstream());
            imagemFoto = new DefaultStreamedContent(evt.getFile().getInputstream(), evt.getFile().getContentType());
        } catch (IOException ex) {
            FacesUtil.addFatal("FALHA DO SISTEMA", null);
        }
    }

    public boolean validaFotoPessoa() {
        for (ArquivoPessoa obj : ((PessoaFisica) selecionado).getArquivosPessoa()) {
            if (obj.getArquivo().getTipoArquivo().equals(TipoArquivo.FOTO_PESSOAL)) {
                FacesUtil.addWarn("Atenção!", "A Pessoa Já Possui uma foto!");
                return false;
            }
        }
        return true;
    }

    public void adicionaFotoPessoa(FileUploadEvent evento) {
        arquivo.setMimeType(evento.getFile().getContentType());
        arquivo.setNome(evento.getFile().getFileName());
        arquivo.setTipoArquivo(TipoArquivo.FOTO_PESSOAL);
        ArquivoPessoa arquivoPessoa = new ArquivoPessoa();
        arquivoPessoa.setPessoa((PessoaFisica) selecionado);
        arquivoPessoa.setArquivo(arquivo);
        ((PessoaFisica) selecionado).getArquivosPessoa().add(arquivoPessoa);
    }

    public InputStream recuperaFotoPessoa() {
        for (ArquivoPessoa obj : ((PessoaFisica) selecionado).getArquivosPessoa()) {
            if (obj.getArquivo().getTipoArquivo().equals(TipoArquivo.FOTO_PESSOAL)) {
                System.out.println("input -- " + obj.getArquivo().getInputStream().toString());
                return obj.getArquivo().getInputStream();
            }
        }
        return null;
    }

    public List<SelectItem> getTiposEndereco() {
        List<SelectItem> toReturn = new ArrayList<>();
        toReturn.add(new SelectItem(null, ""));
        for (TipoEndereco obj : TipoEndereco.values()) {
            toReturn.add(new SelectItem(obj, obj.getDescricao()));
        }
        return toReturn;
    }

    public List<SelectItem> getTiposTelefone() {
        List<SelectItem> toReturn = new ArrayList<>();
        toReturn.add(new SelectItem(null, ""));
        for (TipoTelefone obj : TipoTelefone.values()) {
            toReturn.add(new SelectItem(obj, obj.getDescricao()));
        }
        return toReturn;
    }

    public boolean validaEndereco() {
        boolean toReturn = true;

        if (endereco.getTipoEndereco() == null) {
            FacesUtil.addWarn("Atenção!", "O Tipo de Endereço é um campo obrigatório.");
            toReturn = false;
        }
        if (endereco.getLogradouro() == null || endereco.getLogradouro().trim().equals("")) {
            FacesUtil.addWarn("Atenção!", "O Logradaouro é um campo obrigatório.");
            toReturn = false;
        }
        if (endereco.getNumero() == null || endereco.getNumero().trim().equals("")) {
            FacesUtil.addWarn("Atenção!", "O Número é um campo obrigatório.");
            toReturn = false;
        }
        if (endereco.getBairro() == null || endereco.getBairro().trim().equals("")) {
            FacesUtil.addWarn("Atenção!", "O Bairro é um campo obrigatório.");
            toReturn = false;
        }
        if (endereco.getCep() == null || Util.removeMascaras(endereco.getCep()).trim().equals("")) {
            FacesUtil.addWarn("Atenção!", "O CEP é um campo obrigatório.");
            toReturn = false;
        }

        return toReturn;
    }

    public boolean validaTelefone() {
        boolean valida = true;
        if (telefone.getTipoTelefone() == null) {
            valida = false;
            FacesUtil.addWarn("Atenção!", "O Tipo de Telefone é um campo obrigatório");
        }
        if (telefone.getNumero().trim().equals("") || telefone.getNumero() == null) {
            valida = false;
            FacesUtil.addWarn("Atenção!", "O Número do Telefone é um campo obrigatório");
        }
        return valida;
    }

    public boolean validaPessoa() {
        boolean valida = true;
        if (((PessoaFisica) selecionado).getNome().trim().equals("") || ((PessoaFisica) selecionado).getNome() == null) {
            FacesUtil.addWarn("Atenção!", "O nome da pessoa é um campo obrigatório.");
            valida = false;
        }

        if (((PessoaFisica) selecionado).getCpf().trim().equals("") || ((PessoaFisica) selecionado).getCpf() == null) {
            FacesUtil.addWarn("Atenção!", "O CPF da pessoa é um campo obrigatório.");
            valida = false;
        } else {
            if (!validaCPF()) {
                valida = false;
            }
        }

        if (((PessoaFisica) selecionado).getEnderecos().isEmpty()) {
            FacesUtil.addWarn("Atenção!", "É necessário cadastrar ao menos um endereço");
            valida = false;
        }
        if (((PessoaFisica) selecionado).getTelefones().isEmpty()) {
            FacesUtil.addWarn("Atenção!", "É necessário cadastrar ao menos um telefone");
            valida = false;
        }
        return valida;
    }

    public void validaEMail() {
        RequestContext.getCurrentInstance().execute("IsEmail('" + ((PessoaFisica) selecionado).geteMail() + "')");
    }

    public void adicionaEndereco() {
        System.out.println("CHAMARrrr2");
        if (validaEndereco()) {
            System.out.println("chamou");
            EnderecoPessoa enderecoPessoa = new EnderecoPessoa();
            enderecoPessoa.setEnderecoCorreio(endereco);
            enderecoPessoa.setPessoa(selecionado);
            listaEderecoPessoa.add(enderecoPessoa);
            endereco = new EnderecoCorreio();
        }
        System.out.println(listaEderecoPessoa.size());
    }

    public void removeEndereco(QEnderecoPessoa endereco) {
        listaEderecoPessoa.remove(endereco);
    }

    public void adicionaTelefone() {
        if (validaTelefone()) {
            telefone.setPessoa((PessoaFisica) selecionado);
            listaTelefones.add(telefone);
            telefone = new Telefone();
        }
    }

    public void removeTelefone(Telefone telefone) {
        listaTelefones.remove(telefone);
    }

    @Override
    public SuperFacade getEsteFacade() {
        return pessoaFisicaFacade;
    }
}

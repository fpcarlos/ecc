/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.AtividadeControle;
import br.org.dioceseroraima.ecc.controle.CasalControle;
import br.org.dioceseroraima.ecc.controle.EventoAtividadeControle;
import br.org.dioceseroraima.ecc.controle.EventoControle;
import br.org.dioceseroraima.ecc.controle.FuncaoControle;
import br.org.dioceseroraima.ecc.modelo.Atividade;
import br.org.dioceseroraima.ecc.modelo.Casal;
import br.org.dioceseroraima.ecc.modelo.Evento;
import br.org.dioceseroraima.ecc.modelo.EventoAtividade;
import br.org.dioceseroraima.ecc.modelo.Funcao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class ProgramacaoVisao extends AbstractVisao implements Serializable {

    @EJB
    private EventoAtividadeControle eventoAtividadeControle;
    @EJB
    private AtividadeControle atividadeControle;
    @EJB
    private EventoControle eventoControle;
    @EJB
    private CasalControle casalControle;
    @EJB
    private FuncaoControle funcaoControle;

    private EventoAtividade eventoAtividade;

    private List<EventoAtividade> listEventoAtividade = new ArrayList<>();
    private List<Evento> listEvento = new ArrayList<>();
    private List<Funcao> listFuncao = new ArrayList<>();
    private List<Atividade> listAtividade = new ArrayList<>();
    private List<Casal> listCasal = new ArrayList<>();

    public ProgramacaoVisao() {

    }

    public String abrirCadastro() {
        try {
            eventoAtividade = new EventoAtividade();

            listFuncao = new ArrayList<>();
            listEvento = new ArrayList<>();
            listCasal = new ArrayList<>();;
            listAtividade = new ArrayList<>();
            listEventoAtividade = new ArrayList<>();

            listFuncao = funcaoControle.findAll();
            listEvento = eventoControle.findAll();
            listCasal = casalControle.findAll();
            listAtividade = atividadeControle.findAll();
            listEventoAtividade = eventoAtividadeControle.findAll();

            return redirect("/sistema/admin/cadastro/formProgramacao.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void salvar() {
        try {
            eventoAtividadeControle.salvar(eventoAtividade);

            showFacesMessage("salvo com sucesso!!!", 2);

            eventoAtividade = new EventoAtividade();
            listFuncao = new ArrayList<>();
            listEvento = new ArrayList<>();
            listCasal = new ArrayList<>();;
            listAtividade = new ArrayList<>();
            listEventoAtividade = new ArrayList<>();

            listFuncao = funcaoControle.findAll();
            listEvento = eventoControle.findAll();
            listCasal = casalControle.findAll();
            listAtividade = atividadeControle.findAll();
            listEventoAtividade = eventoAtividadeControle.findAll();

            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }

    public String editar(EventoAtividade aux) {
        try {
            eventoAtividade = eventoAtividadeControle.pegaEventoAtividadeId(aux.getId());

            listFuncao = new ArrayList<>();
            listEvento = new ArrayList<>();
            listCasal = new ArrayList<>();;
            listAtividade = new ArrayList<>();
            listEventoAtividade = new ArrayList<>();

            listFuncao = funcaoControle.findAll();
            listEvento = eventoControle.findAll();
            listCasal = casalControle.findAll();
            listAtividade = atividadeControle.findAll();
            listEventoAtividade = eventoAtividadeControle.findAll();

            return redirect("/sistema/admin/cadastro/formProgramacao.xhtml");

        } catch (Exception e) {
            return null;
        }
    }

    public String remover(EventoAtividade aux) {
        try {
            eventoAtividadeControle.remove(aux);

            showFacesMessage("Usuário deletado com sucesso!!!", 2);
            eventoAtividade = new EventoAtividade();
            listFuncao = new ArrayList<>();
            listEvento = new ArrayList<>();
            listCasal = new ArrayList<>();;
            listAtividade = new ArrayList<>();
            listEventoAtividade = new ArrayList<>();

            listFuncao = funcaoControle.findAll();
            listEvento = eventoControle.findAll();
            listCasal = casalControle.findAll();
            listAtividade = atividadeControle.findAll();
            listEventoAtividade = eventoAtividadeControle.findAll();
            return redirect("/sistema/admin/cadastro/formProgramacao.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    //Gets e Sets

    public EventoAtividade getEventoAtividade() {
        return eventoAtividade;
    }

    public void setEventoAtividade(EventoAtividade eventoAtividade) {
        this.eventoAtividade = eventoAtividade;
    }

    public List<EventoAtividade> getListEventoAtividade() {
        return listEventoAtividade;
    }

    public void setListEventoAtividade(List<EventoAtividade> listEventoAtividade) {
        this.listEventoAtividade = listEventoAtividade;
    }

    public List<Evento> getListEvento() {
        return listEvento;
    }

    public void setListEvento(List<Evento> listEvento) {
        this.listEvento = listEvento;
    }

    public List<Funcao> getListFuncao() {
        return listFuncao;
    }

    public void setListFuncao(List<Funcao> listFuncao) {
        this.listFuncao = listFuncao;
    }

    public List<Atividade> getListAtividade() {
        return listAtividade;
    }

    public void setListAtividade(List<Atividade> listAtividade) {
        this.listAtividade = listAtividade;
    }

    public List<Casal> getListCasal() {
        return listCasal;
    }

    public void setListCasal(List<Casal> listCasal) {
        this.listCasal = listCasal;
    }

}

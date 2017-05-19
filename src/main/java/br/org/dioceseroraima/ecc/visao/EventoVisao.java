/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.EventoControle;
import br.org.dioceseroraima.ecc.controle.ParoquiaControle;
import br.org.dioceseroraima.ecc.modelo.Evento;
import br.org.dioceseroraima.ecc.modelo.Paroquia;
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
public class EventoVisao extends AbstractVisao implements Serializable {

    @EJB
    private EventoControle eventoControle;

    @EJB
    private ParoquiaControle paroquiaControle;

    private Evento evento;

    private List<Evento> listEvento = new ArrayList<>();

    private List<Paroquia> listParoquia = new ArrayList<>();

    public EventoVisao() {

    }

    public String abrirCadastro() {
        try {
            evento = new Evento();
            listEvento = new ArrayList<>();
            listEvento = eventoControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            //System.out.println("Entrando no site");

            return redirect("/sistema/admin/cadastro/formEvento.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void salvar() {
        try {
            eventoControle.salvar(evento);

            showFacesMessage("salvo com sucesso!!!", 2);

            evento = new Evento();
            listEvento = new ArrayList<>();
            listEvento = eventoControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }

    public String editar(Evento aux) {
        try {
            evento = eventoControle.pegaEventoId(aux.getId());

            listEvento = new ArrayList<>();
            listEvento = eventoControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();

            return redirect("/sistema/admin/cadastro/formEvento.xhtml");

        } catch (Exception e) {
            return null;
        }
    }

    public String remover(Evento aux) {
        try {
            eventoControle.remove(evento);

            showFacesMessage("Usuário deletado com sucesso!!!", 2);

            evento = new Evento();
            listEvento = new ArrayList<>();
            listEvento = eventoControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            return redirect("/sistema/admin/cadastro/formEvento.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }

    //Gets e Sets
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getListEvento() {
        return listEvento;
    }

    public void setListEvento(List<Evento> listEvento) {
        this.listEvento = listEvento;
    }

    public List<Paroquia> getListParoquia() {
        return listParoquia;
    }

    public void setListParoquia(List<Paroquia> listParoquia) {
        this.listParoquia = listParoquia;
    }

}

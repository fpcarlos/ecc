/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.AtividadeControle;
import br.org.dioceseroraima.ecc.modelo.Atividade;
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
public class AtividadeVisao extends AbstractVisao implements Serializable {

    @EJB
    private AtividadeControle atividadeControle;

    private Atividade atividade;

    private List<Atividade> listAtividade = new ArrayList<>();

    public AtividadeVisao() {

    }

    public String abrirCadastro() {
        try {
            atividade = new Atividade();
            listAtividade = new ArrayList<>();
            listAtividade = atividadeControle.findAll();
            return redirect("/sistema/admin/cadastro/formAtividade.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void salvar() {
        try {
            atividadeControle.salvar(atividade);

            showFacesMessage("salvo com sucesso!!!", 2);

            atividade = new Atividade();
            listAtividade = new ArrayList<>();
            listAtividade = atividadeControle.findAll();

            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }

    public String editar(Atividade aux) {
        try {
            atividade = atividadeControle.pegaAtividadeId(aux.getId());
            listAtividade = new ArrayList<>();
            listAtividade = atividadeControle.findAll();

            return redirect("/sistema/admin/cadastro/formAtividade.xhtml");

        } catch (Exception e) {
            return null;
        }
    }

    public String remover(Atividade aux) {
        try {
            atividadeControle.remove(aux);

            showFacesMessage("Usuário deletado com sucesso!!!", 2);

            atividade = new Atividade();
            listAtividade = new ArrayList<>();
            listAtividade = atividadeControle.findAll();

            return redirect("/sistema/admin/cadastro/formAtividade.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    //Gets e Sts

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public List<Atividade> getListAtividade() {
        return listAtividade;
    }

    public void setListAtividade(List<Atividade> listAtividade) {
        this.listAtividade = listAtividade;
    }

}

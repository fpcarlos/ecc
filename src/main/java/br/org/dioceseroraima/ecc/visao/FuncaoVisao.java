/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.FuncaoControle;
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
public class FuncaoVisao extends AbstractVisao implements Serializable{
    
    @EJB
    private FuncaoControle funcaoControle;
    
    private Funcao funcao;
    
    private List<Funcao> listFuncao = new ArrayList<>();
    
    
    public FuncaoVisao(){
        
    }
    
    public String abrirCadastro() {
        try {
            funcao = new Funcao();
            listFuncao = new ArrayList<>();
            listFuncao = funcaoControle.findAll();
            
            return redirect("/sistema/admin/cadastro/formFuncao.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void salvar() {
        try {
            funcaoControle.salvar(funcao);

            showFacesMessage("salvo com sucesso!!!", 2);

            funcao = new Funcao();
            listFuncao = new ArrayList<>();
            listFuncao = funcaoControle.findAll();

            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }

    public String editar(Funcao aux) {
        try {
            funcao = funcaoControle.pegaFuncaoId(aux.getId());
            
            listFuncao = new ArrayList<>();
            listFuncao = funcaoControle.findAll();

            return redirect("/sistema/admin/cadastro/formFuncao.xhtml");

        } catch (Exception e) {
            return null;
        }
    }

    public String remover(Funcao aux) {
        try {
            funcaoControle.remove(aux);
            

            showFacesMessage("Usuário deletado com sucesso!!!", 2);

            funcao = new Funcao();
            listFuncao = new ArrayList<>();
            listFuncao = funcaoControle.findAll();

            return redirect("/sistema/admin/cadastro/formFuncao.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    
    
    //Gets e Sets

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public List<Funcao> getListFuncao() {
        return listFuncao;
    }

    public void setListFuncao(List<Funcao> listFuncao) {
        this.listFuncao = listFuncao;
    }
    
    
    
    
}

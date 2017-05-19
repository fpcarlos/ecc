/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.CasalControle;
import br.org.dioceseroraima.ecc.controle.ParoquiaControle;
import br.org.dioceseroraima.ecc.controle.PessoaControle;
import br.org.dioceseroraima.ecc.modelo.Casal;
import br.org.dioceseroraima.ecc.modelo.Paroquia;
import br.org.dioceseroraima.ecc.modelo.Pessoa;
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
public class CasalVisao extends AbstractVisao implements Serializable{
    
    @EJB
    private CasalControle casalControle;
    
    @EJB
    private PessoaControle pessoaControle;
    
    @EJB
    private ParoquiaControle paroquiaControle;
    
    private Casal casal;
    
    private List<Casal> listCasal = new ArrayList<>();
    
    private List<Pessoa> listPessoa = new ArrayList<>();
    
    private List<Paroquia> listParoquia = new ArrayList<>();
    
    
    
    
    public CasalVisao(){
        
    }
    
    public String abrirCadastro(){
        try {
            casal = new Casal();
            
            listCasal = new ArrayList<>();
            listPessoa= new ArrayList<>();
            listParoquia= new ArrayList<>();
            
            listCasal = casalControle.findAll();
            listPessoa= pessoaControle.findAll();
            listParoquia = paroquiaControle.findAll();
            
            return redirect("/sistema/admin/cadastro/formCasal.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvar(){
        try {
            casalControle.salvar(casal);
            
            showFacesMessage("salvo com sucesso!!!", 2);
            casal = new Casal();
            
            listCasal = new ArrayList<>();
            listPessoa= new ArrayList<>();
            listParoquia= new ArrayList<>();
             listCasal = casalControle.findAll();
            listPessoa= pessoaControle.findAll();
            listParoquia = paroquiaControle.findAll();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }
    
    public String editar(Casal aux){
         try {
             casal = casalControle.pegaCasalId(aux.getId());
            listCasal = new ArrayList<>();
            listPessoa= new ArrayList<>();
            listParoquia= new ArrayList<>();
             listCasal = casalControle.findAll();
            listPessoa= pessoaControle.findAll();
            listParoquia = paroquiaControle.findAll();
            
            return redirect("/sistema/admin/cadastro/formCasal.xhtml");

        } catch (Exception e) {
            return null;
        }
    }
    
    public String remover(Casal aux){
        try {
            casalControle.remove(aux);
            
            
            showFacesMessage("Usuário deletado com sucesso!!!", 2);
            casal = new Casal();
            
            listCasal = new ArrayList<>();
            listPessoa= new ArrayList<>();
            listParoquia= new ArrayList<>();
             listCasal = casalControle.findAll();
            listPessoa= pessoaControle.findAll();
            listParoquia = paroquiaControle.findAll();
            return redirect("/sistema/admin/cadastro/formCasal.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    
    
    
    //Gets e Sets

    public Casal getCasal() {
        return casal;
    }

    public void setCasal(Casal casal) {
        this.casal = casal;
    }

    public List<Casal> getListCasal() {
        return listCasal;
    }

    public void setListCasal(List<Casal> listCasal) {
        this.listCasal = listCasal;
    }

    public List<Pessoa> getListPessoa() {
        return listPessoa;
    }

    public void setListPessoa(List<Pessoa> listPessoa) {
        this.listPessoa = listPessoa;
    }

    public List<Paroquia> getListParoquia() {
        return listParoquia;
    }

    public void setListParoquia(List<Paroquia> listParoquia) {
        this.listParoquia = listParoquia;
    }
    
    
    
}

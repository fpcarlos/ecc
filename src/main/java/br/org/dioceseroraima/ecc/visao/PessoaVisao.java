/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.PessoaControle;
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
public class PessoaVisao extends AbstractVisao implements Serializable{
    
    @EJB
    private PessoaControle pessoaControle;
    
    private Pessoa pessoa;
    
    private List<Pessoa> listPessoa = new ArrayList<>();
    
    public PessoaVisao(){
        
    }
    
    
    public String abrirCadastro(){
        try {
            pessoa = new Pessoa();
            listPessoa = new ArrayList<>();
            listPessoa = pessoaControle.findAll();
            return redirect("/sistema/admin/cadastro/formPessoa.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvar(){
        try {
            pessoaControle.salvar(pessoa);;
            
            showFacesMessage("salvo com sucesso!!!", 2);
            pessoa = new Pessoa();
            listPessoa = new ArrayList<>();
            listPessoa = pessoaControle.findAll();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }
    
    public String editar(Pessoa aux){
         try {
            pessoa = pessoaControle.pegaPessoaId(aux.getId());
            
            listPessoa = new ArrayList<>();
            listPessoa = pessoaControle.findAll();
            return redirect("/sistema/admin/cadastro/formPessoa.xhtml");

        } catch (Exception e) {
            return null;
        }
    }
    
    public String remover(Pessoa aux){
        try {
            pessoaControle.remove(aux);
            
            showFacesMessage("Usuário deletado com sucesso!!!", 2);
            pessoa = new Pessoa();
            listPessoa = new ArrayList<>();
            listPessoa = pessoaControle.findAll();
            
            return redirect("/sistema/admin/cadastro/formPessoa.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    
    
    
    //Gets e Sets

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getListPessoa() {
        return listPessoa;
    }

    public void setListPessoa(List<Pessoa> listPessoa) {
        this.listPessoa = listPessoa;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.DioceseControle;
import br.org.dioceseroraima.ecc.modelo.Diocese;
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
public class DioceseVisao extends AbstractVisao implements Serializable{
    
    @EJB
    private DioceseControle dioceseControle;
    
    private Diocese diocese;
    
    private List<Diocese> listDiocese = new ArrayList<>();
    
    public DioceseVisao(){
        
    }
    
    
    public String abrirCadastro(){
        try {
            diocese = new Diocese();
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            return redirect("/sistema/admin/cadastro/formDiocese.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvar(){
        try {
            dioceseControle.salvar(diocese);
            showFacesMessage("salvo com sucesso!!!", 2);
            diocese = new Diocese();
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }
    
    public String editar(Diocese aux){
         try {
            diocese = dioceseControle.pegaDioceseId(aux.getId());            
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            return redirect("/sistema/admin/cadastro/formDiocese.xhtml");

        } catch (Exception e) {
            return null;
        }
    }
    
    public String remover(Diocese aux){
        try {
            dioceseControle.remove(aux);
            
            showFacesMessage("Usuário deletado com sucesso!!!", 2);
            diocese = new Diocese();
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            return redirect("/sistema/admin/cadastro/formDiocese.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    //Gets e Sets

    public Diocese getDiocese() {
        return diocese;
    }

    public void setDiocese(Diocese diocese) {
        this.diocese = diocese;
    }

    public List<Diocese> getListDiocese() {
        return listDiocese;
    }

    public void setListDiocese(List<Diocese> listDiocese) {
        this.listDiocese = listDiocese;
    }
    
    
    
}

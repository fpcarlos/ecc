/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.visao;

import br.org.dioceseroraima.ecc.controle.DioceseControle;
import br.org.dioceseroraima.ecc.controle.ParoquiaControle;
import br.org.dioceseroraima.ecc.modelo.Diocese;
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
public class ParoquiaVisao extends AbstractVisao implements Serializable{
    
    @EJB
    private ParoquiaControle paroquiaControle;
    
    @EJB
    private DioceseControle dioceseControle;
    
    private Paroquia paroquia;
    
    private List<Diocese> listDiocese = new ArrayList<>();
    
    private List<Paroquia> listParoquia = new ArrayList<>();
    
    
    public ParoquiaVisao(){
        
    }
    
    public String abrirCadastro(){
        try {
            paroquia = new Paroquia();
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            return redirect("/sistema/admin/cadastro/formParoquia.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvar(){
        try {
            paroquiaControle.salvar(paroquia);
            showFacesMessage("salvo com sucesso!!!", 2);           
            paroquia = new Paroquia();
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/usuario/listaUsuarios.xhtml");
            //return redirect("/sistema/usuario/listaUsuarios.xhtml?faces-redirect=true");
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            //return null;
        }
    }
    
    public String editar(Paroquia aux){
         try {
            paroquia = paroquiaControle.pegaParoquiaId(aux.getId());
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            return redirect("/sistema/admin/cadastro/formParoquia.xhtml");

        } catch (Exception e) {
            return null;
        }
    }
    
    public String remover(Paroquia aux){
        try {
            paroquiaControle.remove(aux);
            
            showFacesMessage("Usuário deletado com sucesso!!!", 2);
            paroquia = new Paroquia();
            listDiocese = new ArrayList<>();
            listDiocese = dioceseControle.findAll();
            listParoquia = new ArrayList<>();
            listParoquia = paroquiaControle.findAll();
            return redirect("/sistema/admin/cadastro/formParoquia.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    //Gets e Sets

    public Paroquia getParoquia() {
        return paroquia;
    }

    public void setParoquia(Paroquia paroquia) {
        this.paroquia = paroquia;
    }

    public List<Diocese> getListDiocese() {
        return listDiocese;
    }

    public void setListDiocese(List<Diocese> listDiocese) {
        this.listDiocese = listDiocese;
    }

    public List<Paroquia> getListParoquia() {
        return listParoquia;
    }

    public void setListParoquia(List<Paroquia> listParoquia) {
        this.listParoquia = listParoquia;
    }
    
    
}

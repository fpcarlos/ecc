/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.modelo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "casal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casal.findAll", query = "SELECT c FROM Casal c")
    , @NamedQuery(name = "Casal.findById", query = "SELECT c FROM Casal c WHERE c.id = :id")
    , @NamedQuery(name = "Casal.findByNumeroFilho", query = "SELECT c FROM Casal c WHERE c.numeroFilho = :numeroFilho")
    , @NamedQuery(name = "Casal.findByCasadoObs", query = "SELECT c FROM Casal c WHERE c.casadoObs = :casadoObs")})
public class Casal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_filho")
    private Integer numeroFilho;
    @Size(max = 2147483647)
    @Column(name = "casado_obs")
    private String casadoObs;
    @JoinColumn(name = "id_paroquia", referencedColumnName = "id")
    @ManyToOne
    private Paroquia idParoquia;
    @JoinColumn(name = "id_esposa", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idEsposa;
    @JoinColumn(name = "id_marido", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idMarido;
    @OneToMany(mappedBy = "idCasal")
    private List<EventoAtividade> eventoAtividadeList;

    public Casal() {
    }

    public Casal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroFilho() {
        return numeroFilho;
    }

    public void setNumeroFilho(Integer numeroFilho) {
        this.numeroFilho = numeroFilho;
    }

    public String getCasadoObs() {
        return casadoObs;
    }

    public void setCasadoObs(String casadoObs) {
        this.casadoObs = casadoObs;
    }

    public Paroquia getIdParoquia() {
        return idParoquia;
    }

    public void setIdParoquia(Paroquia idParoquia) {
        this.idParoquia = idParoquia;
    }

    public Pessoa getIdEsposa() {
        return idEsposa;
    }

    public void setIdEsposa(Pessoa idEsposa) {
        this.idEsposa = idEsposa;
    }

    public Pessoa getIdMarido() {
        return idMarido;
    }

    public void setIdMarido(Pessoa idMarido) {
        this.idMarido = idMarido;
    }

    @XmlTransient
    public List<EventoAtividade> getEventoAtividadeList() {
        return eventoAtividadeList;
    }

    public void setEventoAtividadeList(List<EventoAtividade> eventoAtividadeList) {
        this.eventoAtividadeList = eventoAtividadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casal)) {
            return false;
        }
        Casal other = (Casal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.dioceseroraima.ecc.modelo.Casal[ id=" + id + " ]";
    }
    
}

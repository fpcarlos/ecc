/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "evento_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventoAtividade.findAll", query = "SELECT e FROM EventoAtividade e")
    , @NamedQuery(name = "EventoAtividade.findById", query = "SELECT e FROM EventoAtividade e WHERE e.id = :id")
    , @NamedQuery(name = "EventoAtividade.findByDataHoraFim", query = "SELECT e FROM EventoAtividade e WHERE e.dataHoraFim = :dataHoraFim")
    , @NamedQuery(name = "EventoAtividade.findByDataHoraInicio", query = "SELECT e FROM EventoAtividade e WHERE e.dataHoraInicio = :dataHoraInicio")})
public class EventoAtividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_hora_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraFim;
    @Column(name = "data_hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraInicio;
    @JoinColumn(name = "id_atividade", referencedColumnName = "id")
    @ManyToOne
    private Atividade idAtividade;
    @JoinColumn(name = "id_casal", referencedColumnName = "id")
    @ManyToOne
    private Casal idCasal;
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    @ManyToOne
    private Evento idEvento;
    @JoinColumn(name = "id_funcao", referencedColumnName = "id")
    @ManyToOne
    private Funcao idFuncao;

    public EventoAtividade() {
    }

    public EventoAtividade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Atividade getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Atividade idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Casal getIdCasal() {
        return idCasal;
    }

    public void setIdCasal(Casal idCasal) {
        this.idCasal = idCasal;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Funcao getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Funcao idFuncao) {
        this.idFuncao = idFuncao;
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
        if (!(object instanceof EventoAtividade)) {
            return false;
        }
        EventoAtividade other = (EventoAtividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.dioceseroraima.ecc.modelo.EventoAtividade[ id=" + id + " ]";
    }
    
}

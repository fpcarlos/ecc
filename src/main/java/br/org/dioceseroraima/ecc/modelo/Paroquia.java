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
@Table(name = "paroquia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paroquia.findAll", query = "SELECT p FROM Paroquia p")
    , @NamedQuery(name = "Paroquia.findById", query = "SELECT p FROM Paroquia p WHERE p.id = :id")
    , @NamedQuery(name = "Paroquia.findByEndereco", query = "SELECT p FROM Paroquia p WHERE p.endereco = :endereco")
    , @NamedQuery(name = "Paroquia.findByTelefone", query = "SELECT p FROM Paroquia p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Paroquia.findBySitio", query = "SELECT p FROM Paroquia p WHERE p.sitio = :sitio")
    , @NamedQuery(name = "Paroquia.findByEmail", query = "SELECT p FROM Paroquia p WHERE p.email = :email")
    , @NamedQuery(name = "Paroquia.findByNome", query = "SELECT p FROM Paroquia p WHERE p.nome = :nome")})
public class Paroquia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 2147483647)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 2147483647)
    @Column(name = "sitio")
    private String sitio;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idParoquia")
    private List<Casal> casalList;
    @OneToMany(mappedBy = "idParoquia")
    private List<Evento> eventoList;
    @JoinColumn(name = "id_diocese", referencedColumnName = "id")
    @ManyToOne
    private Diocese idDiocese;

    public Paroquia() {
    }

    public Paroquia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Casal> getCasalList() {
        return casalList;
    }

    public void setCasalList(List<Casal> casalList) {
        this.casalList = casalList;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public Diocese getIdDiocese() {
        return idDiocese;
    }

    public void setIdDiocese(Diocese idDiocese) {
        this.idDiocese = idDiocese;
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
        if (!(object instanceof Paroquia)) {
            return false;
        }
        Paroquia other = (Paroquia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.dioceseroraima.ecc.modelo.Paroquia[ id=" + id + " ]";
    }
    
}

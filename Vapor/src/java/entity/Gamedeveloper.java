/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Beta
 */
@Entity
@Table(name = "gamedeveloper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gamedeveloper.findAll", query = "SELECT g FROM Gamedeveloper g"),
    @NamedQuery(name = "Gamedeveloper.findById", query = "SELECT g FROM Gamedeveloper g WHERE g.id = :id"),
    @NamedQuery(name = "Gamedeveloper.findByDName", query = "SELECT g FROM Gamedeveloper g WHERE g.dName = :dName")
})
public class Gamedeveloper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dName")
    private String dName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameDeveloperid")
    private Collection<Myitem> myitemCollection;

    public Gamedeveloper() {
    }

    public Gamedeveloper(Integer id) {
        this.id = id;
    }

    public Gamedeveloper(Integer id, String dName) {
        this.id = id;
        this.dName = dName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    @XmlTransient
    public Collection<Myitem> getMyitemCollection() {
        return myitemCollection;
    }

    public void setMyitemCollection(Collection<Myitem> myitemCollection) {
        this.myitemCollection = myitemCollection;
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
        if (!(object instanceof Gamedeveloper)) {
            return false;
        }
        Gamedeveloper other = (Gamedeveloper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gamedeveloper[ id=" + id + " ]";
    }

}

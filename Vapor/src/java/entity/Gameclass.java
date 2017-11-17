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
@Table(name = "gameclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gameclass.findAll", query = "SELECT g FROM Gameclass g"),
    @NamedQuery(name = "Gameclass.findById", query = "SELECT g FROM Gameclass g WHERE g.id = :id"),
    @NamedQuery(name = "Gameclass.findByCName", query = "SELECT g FROM Gameclass g WHERE g.cName = :cName")
})
public class Gameclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cName")
    private String cName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameClassid")
    private Collection<Myitem> myitemCollection;

    public Gameclass() {
    }

    public Gameclass(Integer id) {
        this.id = id;
    }

    public Gameclass(Integer id, String cName) {
        this.id = id;
        this.cName = cName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
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
        if (!(object instanceof Gameclass)) {
            return false;
        }
        Gameclass other = (Gameclass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gameclass[ id=" + id + " ]";
    }

}

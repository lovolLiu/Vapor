/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Beta
 */
@Entity
@Table(name = "gamepicture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gamepicture.findAll", query = "SELECT g FROM Gamepicture g"),
    @NamedQuery(name = "Gamepicture.findById", query = "SELECT g FROM Gamepicture g WHERE g.id = :id"),
    @NamedQuery(name = "Gamepicture.findByUrl", query = "SELECT g FROM Gamepicture g WHERE g.url = :url")})
public class Gamepicture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "myItem_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Myitem myItemid;

    public Gamepicture() {
    }

    public Gamepicture(Integer id) {
        this.id = id;
    }

    public Gamepicture(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Myitem getMyItemid() {
        return myItemid;
    }

    public void setMyItemid(Myitem myItemid) {
        this.myItemid = myItemid;
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
        if (!(object instanceof Gamepicture)) {
            return false;
        }
        Gamepicture other = (Gamepicture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gamepicture[ id=" + id + " ]";
    }

}

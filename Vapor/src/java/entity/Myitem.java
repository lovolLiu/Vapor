/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Beta
 */
@Entity
@Table(name = "myitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myitem.findAll", query = "SELECT m FROM Myitem m"),
    @NamedQuery(name = "Myitem.findById", query = "SELECT m FROM Myitem m WHERE m.id = :id"),
    @NamedQuery(name = "Myitem.findByName", query = "SELECT m FROM Myitem m WHERE m.name = :name"),
    @NamedQuery(name = "Myitem.findByPrice", query = "SELECT m FROM Myitem m WHERE m.price = :price"),
    @NamedQuery(name = "Myitem.findByDescription", query = "SELECT m FROM Myitem m WHERE m.description = :description"),
    @NamedQuery(name = "Myitem.findByPubTime", query = "SELECT m FROM Myitem m WHERE m.pubTime = :pubTime"),
    @NamedQuery(name = "Myitem.findByTimesOfBuy", query = "SELECT m FROM Myitem m WHERE m.timesOfBuy = :timesOfBuy"),
    @NamedQuery(name = "Myitem.getHottestGames", query = "SELECT m FROM Myitem m ORDER BY m.timesOfBuy DESC")
})
public class Myitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pubTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "times_of_buy")
    private int timesOfBuy;
    @JoinColumn(name = "gameClass_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gameclass gameClassid;
    @JoinColumn(name = "gameDeveloper_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gamedeveloper gameDeveloperid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myItemid")
    private Collection<OrderItem> orderItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myItemid")
    private Collection<Cart> cartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myItemid")
    private Collection<Gamepicture> gamepictureCollection;

    public Myitem() {
    }

    public Myitem(Integer id) {
        this.id = id;
    }

    public Myitem(Integer id, String name, float price, String description, Date pubTime, int timesOfBuy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.pubTime = pubTime;
        this.timesOfBuy = timesOfBuy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public int getTimesOfBuy() {
        return timesOfBuy;
    }

    public void setTimesOfBuy(int timesOfBuy) {
        this.timesOfBuy = timesOfBuy;
    }

    public Gameclass getGameClassid() {
        return gameClassid;
    }

    public void setGameClassid(Gameclass gameClassid) {
        this.gameClassid = gameClassid;
    }

    public Gamedeveloper getGameDeveloperid() {
        return gameDeveloperid;
    }

    public void setGameDeveloperid(Gamedeveloper gameDeveloperid) {
        this.gameDeveloperid = gameDeveloperid;
    }

    @XmlTransient
    public Collection<OrderItem> getOrderItemCollection() {
        return orderItemCollection;
    }

    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
        this.orderItemCollection = orderItemCollection;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @XmlTransient
    public Collection<Gamepicture> getGamepictureCollection() {
        return gamepictureCollection;
    }

    public void setGamepictureCollection(Collection<Gamepicture> gamepictureCollection) {
        this.gamepictureCollection = gamepictureCollection;
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
        if (!(object instanceof Myitem)) {
            return false;
        }
        Myitem other = (Myitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Myitem[ id=" + id + " ]";
    }

}

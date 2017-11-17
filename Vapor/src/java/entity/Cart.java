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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Cart entity.
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid"),
    @NamedQuery(name = "Cart.findByUser", query = "SELECT c FROM Cart c WHERE c.myUserid = :user"),
    @NamedQuery(name = "Cart.findByUserID_ItemID", query = "SELECT c FROM Cart c WHERE c.myUserid = :myUserid AND c.myItemid = :myItemid")
})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cart_id")
    private Integer cartid;
    @JoinColumn(name = "myItem_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Myitem myItemid;
    @JoinColumn(name = "myUser_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Myuser myUserid;

    public Cart() {
    }

    public Cart(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Myitem getMyItemid() {
        return myItemid;
    }

    public void setMyItemid(Myitem myItemid) {
        this.myItemid = myItemid;
    }

    public Myuser getMyUserid() {
        return myUserid;
    }

    public void setMyUserid(Myuser myUserid) {
        this.myUserid = myUserid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartid != null ? cartid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartid == null && other.cartid != null) || (this.cartid != null && !this.cartid.equals(other.cartid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cart[ cartid=" + cartid + " ]";
    }

}

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
 *
 * @author Beta
 */
@Entity
@Table(name = "order_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
    @NamedQuery(name = "OrderItem.findByOrderItemid", query = "SELECT o FROM OrderItem o WHERE o.orderItemid = :orderItemid"),
    @NamedQuery(name = "OrderItem.findItemByOrderId", query ="SELECT o FROM OrderItem o WHERE o.myOrderid = :myOrderId")
})
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Order_Item_id")
    private Integer orderItemid;
    @JoinColumn(name = "myItem_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Myitem myItemid;
    @JoinColumn(name = "myOrder_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Myorder myOrderid;

    public OrderItem() {
    }

    public OrderItem(Integer orderItemid) {
        this.orderItemid = orderItemid;
    }

    public Integer getOrderItemid() {
        return orderItemid;
    }

    public void setOrderItemid(Integer orderItemid) {
        this.orderItemid = orderItemid;
    }

    public Myitem getMyItemid() {
        return myItemid;
    }

    public void setMyItemid(Myitem myItemid) {
        this.myItemid = myItemid;
    }

    public Myorder getMyOrderid() {
        return myOrderid;
    }

    public void setMyOrderid(Myorder myOrderid) {
        this.myOrderid = myOrderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemid != null ? orderItemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.orderItemid == null && other.orderItemid != null) || (this.orderItemid != null && !this.orderItemid.equals(other.orderItemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderItem[ orderItemid=" + orderItemid + " ]";
    }

}

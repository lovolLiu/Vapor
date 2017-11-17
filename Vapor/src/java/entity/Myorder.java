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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Beta
 */
@Entity
@Table(name = "myorder")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Myorder.findAll", query = "SELECT m FROM Myorder m"),
  @NamedQuery(name = "Myorder.findById", query = "SELECT m FROM Myorder m WHERE m.id = :id"),
  @NamedQuery(name = "Myorder.findByTime", query = "SELECT m FROM Myorder m WHERE m.time = :time"),
  @NamedQuery(name = "Myorder.findByState", query = "SELECT m FROM Myorder m WHERE m.state = :state"),
  @NamedQuery(name = "Myorder.findByUser", query = "SELECT m FROM Myorder m WHERE m.userId = :user"),
})
public class Myorder implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date time;
  @Basic(optional = false)
  @NotNull
  @Column(name = "state")
  private int state;
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Myuser userId;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "myOrderid")
  private Collection<OrderItem> orderItemCollection;

  public Myorder() {
  }

  public Myorder(Integer id) {
    this.id = id;
  }

  public Myorder(Integer id, Date time, int state) {
    this.id = id;
    this.time = time;
    this.state = state;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public Myuser getUserId() {
    return userId;
  }

  public void setUserId(Myuser userId) {
    this.userId = userId;
  }

  @XmlTransient
  public Collection<OrderItem> getOrderItemCollection() {
    return orderItemCollection;
  }

  public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
    this.orderItemCollection = orderItemCollection;
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
    if (!(object instanceof Myorder)) {
      return false;
    }
    Myorder other = (Myorder) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.Myorder[ id=" + id + " ]";
  }
  
}

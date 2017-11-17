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
@Table(name = "myuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myuser.findAll", query = "SELECT m FROM Myuser m"),
    @NamedQuery(name = "Myuser.findById", query = "SELECT m FROM Myuser m WHERE m.id = :id"),
    @NamedQuery(name = "Myuser.findByPassword", query = "SELECT m FROM Myuser m WHERE m.password = :password"),
    @NamedQuery(name = "Myuser.findByUsername", query = "SELECT m FROM Myuser m WHERE m.username = :username"),
    @NamedQuery(name = "Myuser.findByEmail", query = "SELECT m FROM Myuser m WHERE m.email = :email"),
    @NamedQuery(name = "Myuser.findByTel", query = "SELECT m FROM Myuser m WHERE m.tel = :tel"),
    @NamedQuery(name = "Myuser.findByCharge", query = "SELECT m FROM Myuser m WHERE m.charge = :charge"),
    @NamedQuery(name = "Myuser.findByToken", query = "SELECT m FROM Myuser m WHERE m.token = :token")})
public class Myuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "charge")
    private float charge;
    @Size(max = 32)
    @Column(name = "token")
    private String token;

    public Myuser() {
    }

    public Myuser(Integer id) {
        this.id = id;
    }

    public Myuser(Integer id, String password, String username, String email, String tel, float charge) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.tel = tel;
        this.charge = charge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        if (!(object instanceof Myuser)) {
            return false;
        }
        Myuser other = (Myuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Myuser[ id=" + id + " ]";
    }
    
}

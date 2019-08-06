/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_management_webservice.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author graff
 */
@Entity
@Table(name = "benutzer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benutzer.findAll", query = "SELECT b FROM Benutzer b")})
public class Benutzer implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "email")

    private String email;
    @Column(name = "name", nullable = true)
    private String name;
     @Column(name = "surname", nullable = true)
    private String surname;
    @Column(name = "newsletter")
    private Boolean newsletter;
    
    @Column(name = "passwort")
    private String passwort;
    @JoinTable(name = "benutzer_reisetyp", joinColumns = {
        @JoinColumn(name = "benutzer_id", referencedColumnName = "email")}, inverseJoinColumns = {
        @JoinColumn(name = "reisetyp_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Reisetyp> reisetypCollection;

    public Benutzer() {
    }

    public Benutzer(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }
    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    @XmlTransient
    @JsonbTransient 
    public Collection<Reisetyp> getReisetypCollection() {
        return reisetypCollection;
    }

    public void setReisetypCollection(Collection<Reisetyp> reisetypCollection) {
        this.reisetypCollection = reisetypCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benutzer)) {
            return false;
        }
        Benutzer other = (Benutzer) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }
//
//    @Override
//    public String toString() {
//        return "model.Benutzer[ email=" + email + " ]";
//    }
//      public String toJson(){
//       JsonbConfig config = new JsonbConfig()
//               .withPropertyVisibilityStrategy(new PropertyVisibilityStrategy() {
//           @Override
//           public boolean isVisible(Field field) {
//               return true;
//           }
//
//           @Override
//           public boolean isVisible(Method method) {
//               return false;
//             }
//       });
//       return JsonbBuilder.newBuilder()
//               .withConfig(config)
//               .build()
//               .toJson(this);
//   }
}

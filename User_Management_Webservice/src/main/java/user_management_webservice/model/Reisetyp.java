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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author graff
 */
@Entity
@Table(name = "reisetyp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reisetyp.findAll", query = "SELECT r FROM Reisetyp r")})
public class Reisetyp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "bezeichnung")
    private String bezeichnung;
    @ManyToMany(mappedBy = "reisetypCollection", cascade = CascadeType.REMOVE)
    private Collection<Benutzer> benutzerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reisetypReiseveranstaltungId")
    private Collection<Reiseveranstaltung> reiseveranstaltungCollection;

    public Reisetyp() {
    }

    public Reisetyp(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @XmlTransient
    @JsonbTransient 
    public Collection<Benutzer> getBenutzerCollection() {
        return benutzerCollection;
    }

    public void setBenutzerCollection(Collection<Benutzer> benutzerCollection) {
        this.benutzerCollection = benutzerCollection;
    }

    @XmlTransient
    @JsonbTransient 
    public Collection<Reiseveranstaltung> getReiseveranstaltungCollection() {
        return reiseveranstaltungCollection;
    }

    public void setReiseveranstaltungCollection(Collection<Reiseveranstaltung> reiseveranstaltungCollection) {
        this.reiseveranstaltungCollection = reiseveranstaltungCollection;
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
        if (!(object instanceof Reisetyp)) {
            return false;
        }
        Reisetyp other = (Reisetyp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reisetyp[ id=" + id + " ]";
    }
//   public String toJson(){
//         JsonbConfig config = new JsonbConfig()
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

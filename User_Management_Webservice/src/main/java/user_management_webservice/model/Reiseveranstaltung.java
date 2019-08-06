/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_management_webservice.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author graff
 */
@Entity
@Table(name = "reiseveranstaltung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reiseveranstaltung.findAll", query = "SELECT r FROM Reiseveranstaltung r")})
public class Reiseveranstaltung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "beginn")
    @Temporal(TemporalType.DATE)
    private Date beginn;
    @Size(max = 300)
    @Column(name = "beschreibung")
    private String beschreibung;
    @Column(name = "ende")
    @Temporal(TemporalType.DATE)
    private Date ende;
    @Size(max = 255)
    @Column(name = "hyperlink")
    private String hyperlink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preis")
    private double preis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "zielort")
    private String zielort;
    @JoinColumn(name = "reisetyp_reiseveranstaltung_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reisetyp reisetypReiseveranstaltungId;

    public Reiseveranstaltung() {
    }

    public Reiseveranstaltung(Integer id) {
        this.id = id;
    }

    public Reiseveranstaltung(Integer id, Date beginn, double preis, String zielort) {
        this.id = id;
        this.beginn = beginn;
        this.preis = preis;
        this.zielort = zielort;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getBeginn() {
        return beginn;
    }

    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public Date getEnde() {
        return ende;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }
    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }
    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getZielort() {
        return zielort;
    }

    public void setZielort(String zielort) {
        this.zielort = zielort;
    }

    public Reisetyp getReisetypReiseveranstaltungId() {
        return reisetypReiseveranstaltungId;
    }

    public void setReisetypReiseveranstaltungId(Reisetyp reisetypReiseveranstaltungId) {
        this.reisetypReiseveranstaltungId = reisetypReiseveranstaltungId;
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
        if (!(object instanceof Reiseveranstaltung)) {
            return false;
        }
        Reiseveranstaltung other = (Reiseveranstaltung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reiseveranstaltung[ id=" + id + " ]";
    }
//    public String toJson(){
//          JsonbConfig config = new JsonbConfig()
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

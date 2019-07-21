/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graff.hue_01_graf_androidclient.classes;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author graff
 */


public class Reiseveranstaltung implements Serializable {


    private static final long serialVersionUID = 1L;

    private Integer id;

    private Date beginn;

    private String beschreibung;
    private Date ende;
    private String hyperlink;
    private double preis;
    private String zielort;
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
}

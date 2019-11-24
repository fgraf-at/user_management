/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graff.hue_01_graf_androidclient.classes;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author graff
 */

public class Benutzer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String name;
    private String surname;


    private Boolean newsletter;
    private String passwort;

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
        return (this.email != null || other.email == null) && (this.email == null || this.email.equals(other.email));
    }

    @Override
    public String toString() {
        return "model.Benutzer[ email=" + email + " ]";
    }
    
}

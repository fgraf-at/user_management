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

public class Reisetyp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String bezeichnung;

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
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "model.Reisetyp[ id=" + id + " ]";
    }
    
}

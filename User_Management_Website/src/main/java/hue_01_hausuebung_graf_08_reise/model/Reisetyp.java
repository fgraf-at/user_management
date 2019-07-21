/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author graff
 */
@Entity
@Table(name="Reisetyp")
@SequenceGenerator(name = "reisetyp_seq", sequenceName = "reisetyp_seq_id")
public class Reisetyp implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "reisetyp_seq")
    @Column (name="id")
    private int id;
    @Column
    private String bezeichnung;

    public Reisetyp() {
    }

    public Reisetyp(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    
    
 @OneToMany(mappedBy="reisetyp")
 private List<Reiseveranstaltung> reiseveranstaltung = new ArrayList<>();
                 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public List<Reiseveranstaltung> getReiseveranstaltung() {
        return reiseveranstaltung;
    }

    public void setReiseveranstaltung(List<Reiseveranstaltung> reiseveranstaltung) {
        this.reiseveranstaltung = reiseveranstaltung;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reisetyp other = (Reisetyp) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Reisetyp{" + "id=" + id + ", bezeichnung=" + bezeichnung + '}';
    }
    
}

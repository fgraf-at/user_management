/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author graff
 */
@Entity
@Table(name = "Reiseveranstaltung")
@SequenceGenerator(name = "reisever_seq", sequenceName = "reise_seq_id")
public class Reiseveranstaltung implements Serializable {

    private static final long serialVersionUID = 1L;

    public Reiseveranstaltung() {
    }
    

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "reisever_seq")
    private int id;

    @Column(name = "zielort", length = 30, nullable = false)
    @Size(max = 30)
    private String zielort;

    @Column(name = "beschreibung", length = 300)
    @Size(max = 300)
    private String beschreibung;

    @Column(name = "beginn", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date beginn;

    @Column(name = "ende", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date ende;

    @Column(name = "preis", nullable = false)
    private double preis;
    
    
    @Column(name = "hyperlink", nullable = true)
    private String hyperlink;

    @ManyToOne
    @JoinColumn(name = "reisetyp_reiseveranstaltung_id", nullable = false)
    private Reisetyp reisetyp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZielort() {
        return zielort;
    }

    public void setZielort(String zielort) {
        this.zielort = zielort;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getBeginn() {
        return beginn;
    }

    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }

    public Date getEnde() {
        return ende;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }

   
    public Reisetyp getReisetyp() {
        return reisetyp;
    }

    public void setReisetyp(Reisetyp reisetyp) {
        this.reisetyp = reisetyp;
    }

  

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getHyperlink() {
       if(hyperlink != null){
           return hyperlink;
       }else{
           return "";
       }
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Reiseveranstaltung(String zielort, String beschreibung, Date beginn, Date ende, double preis, String hyperlink) {
        this.zielort = zielort;
        this.beschreibung = beschreibung;
        this.beginn = beginn;
        this.ende = ende;
        this.preis = preis;
        this.hyperlink = hyperlink;
    }

    public Reiseveranstaltung(String zielort, String beschreibung, Date beginn, Date ende, double preis, String hyperlink, Reisetyp reisetyp) {
        this.zielort = zielort;
        this.beschreibung = beschreibung;
        this.beginn = beginn;
        this.ende = ende;
        this.preis = preis;
        this.hyperlink = hyperlink;
        this.reisetyp = reisetyp;
    }

    
   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Reiseveranstaltung other = (Reiseveranstaltung) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    

}

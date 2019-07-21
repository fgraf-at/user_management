/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.controller;

import hue_01_hausuebung_graf_08_reise.model.Benutzer;
import hue_01_hausuebung_graf_08_reise.model.Reiseveranstaltung;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Dieser Controller dient der verwaltung des Benutzers
 * @author graff
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    private static final long serialVersionUID = 1L;
    private Benutzer benutzer; //der aktuelle Benutzer
    private boolean loggedIn; // Abfrageboolean 
    private Set<Reiseveranstaltung> lReiseveranstaltung; //Liste der Reiseveranstaltungen des Benutzers

    /**
     * Initialisieren der Instanzvariablen. 
     */
    @PostConstruct
    private void init() {
        benutzer = new Benutzer();
        lReiseveranstaltung = new TreeSet<>();
        loggedIn = false;
    }

    
    //Getter
    public Benutzer getBenutzer() {
        return benutzer;
    }
    public Set<Reiseveranstaltung> getlReiseveranstaltung() {
        return lReiseveranstaltung;
    }
    
    
    
    //Setter 
    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }
    public void setlReiseveranstaltung(Set<Reiseveranstaltung> lReiseveranstaltung) {
        this.lReiseveranstaltung = lReiseveranstaltung;
    }
   
    // Eine Methode die einen entsprechenden String zurück gibt, ob der Benutzer angemeldet ist. 
 public String isLoggedIn(){
     System.out.println("loggedIn" + loggedIn);
     //Abfragen, ob der Benutzer angemeldet ist
        if(loggedIn){
            return "Angemeldet als: " +benutzer.getEmail()+"/Log out"; // wenn der Benutzer angemeldet ist
        }else{
            return "Benutzer ist nicht angemeldet"; // wenn der Benutzer nicht Angemeldet ist-
        }
     
    }
 

 
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
     public boolean getLoggedIn() {
        return loggedIn;
    }
    
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.controller;

import hue_01_hausuebung_graf_08_reise.db.IDAO;
import hue_01_hausuebung_graf_08_reise.model.Benutzer;
import hue_01_hausuebung_graf_08_reise.model.Reisetyp;
import hue_01_hausuebung_graf_08_reise.model.Reiseveranstaltung;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * Dieser Conroller stellt Datenbankmethoden zur Verfügung. 
 * @author graff
 */
@Named(value = "contentController")
@SessionScoped
public class ContentController implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EJB
    private IDAO dao;
    @Inject
    private UserController us;
    
        /**
     * Gibt alle Reiseveranstaltungen in abhängigkeit der vom Benutzer gewählten
     * Reisetypen zurück.
     *
     * @return Eine Liste von Reiseveranstaltungen
     */
    public List<Reiseveranstaltung> getReiseVeranstaltungenFromCurrentUser() {
        Benutzer b = null;
        List<Reiseveranstaltung> lReiseveranstaltung;
        if ((b = dao.getBenutzer(us.getBenutzer())) != null) {
            List<Reisetyp> lReisetyp = getReisetypesFromCurrentUser();
            lReiseveranstaltung = new ArrayList<>();
            for (Reisetyp x : lReisetyp) { // Ich hole mir den Reisetyp
                 // ich füge von dem entsprechenden Reisetyp die Reiseveranstaltung in die Liste
                lReiseveranstaltung.addAll(x.getReiseveranstaltung());
            }
           
            return lReiseveranstaltung; //Liste zurückgeben
        }
        //Fehler auf Konsole ausgeben
        System.err.println("Benutzer nicht gefunden");

        //FacesContext holen und Message hinzufügen
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnung", "Benutzer nicht gefunden");
        fc.addMessage(null, fm);

        return new ArrayList<>(0); //wenn kein Benutzer, dann wird eine leere Liste zurückgegeben.

    }
    public List<Reisetyp> getReisetypesFromCurrentUser(){
       Benutzer b = null;
       if( (b = dao.getBenutzer(us.getBenutzer())) !=null){      
            return b.getReisetyp(); 
       }else{
           return new ArrayList<>(0); // werden keine Reisetypen gefunden wird eine leere liste zurückgegeben
       }
    }
    /**
     * Diese Methode speichert die geänderten Reisetypen des Benutzers
     * @return die aufzurufende Seite
     */
    public String setReisetypenFromCurrentUser(){ 
//Holen des FacesContexts
        FacesContext fc = FacesContext.getCurrentInstance();
        if(dao.mergeBenutzer(us.getBenutzer())){
            fc.addMessage("t", new FacesMessage(FacesMessage.SEVERITY_INFO, "Gespeichert", "Änderungen wurden gespeichert")); //Fehlermeldung wird 
            //im Erfolgsfall in den FacesContext gespeichert
            return "/signedIn.xhtml";
        }else{ 
            fc.addMessage("t", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnung", "Änderungen wurden nicht gespeichert")); //Fehlermeldung wird 
            //im Fehlerfall in den FacesContext gespeichert
             return "/signedIn.xhtml";
        }
       
    }

    /**
     * Mit dieser Methode kann man sich alle Reisetypen holen
     * @return Eine Liste aller Reisetypen
     */
    
    public List<Reisetyp> getAllReisetypes(){
        List<Reisetyp> lReisetyps = new ArrayList<>();
       if( (lReisetyps = dao.getAllReisetypen()) !=null){
           return lReisetyps;
       }else{
           return new ArrayList<>(0); // werden keine Reisetypen gefunden wird eine leere liste zurückgegeben
       }
    }
    /**
     *  Mit dieser Methode kann man sich alle Reisetypen des Benutzers holen
     * @return Eine Liste der Reisetypen des Benutzers
     */
      
      
   
}

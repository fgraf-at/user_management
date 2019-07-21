/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.controller;

import hue_01_hausuebung_graf_08_reise.db.IDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * Diese Controller ist für den Login zuständig
 * @author graff
 */
@Named(value = "LoginController")
@RequestScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private IDAO dao;

    @Inject
    private UserController us;
    /**
     * Diese Methode ist für den Login. Wenn der Benutztzer in der Datenbank ist
     * wird eine neue Benutzersitzung erstellt und das Session-Timeout gesetzt.
     * Ansonsten wird eine Fehlermedung zuräückgegeben.
     * @return Die neue Seite
     */
    public String login() {
       FacesContext fc = FacesContext.getCurrentInstance();
        if (dao.validate(us.getBenutzer())) { //wenn der Benutzer vorhanden ist und das Passwort stimmt wird man auf die nächste Seite geleitet
            us.setBenutzer(dao.getBenutzer(us.getBenutzer()));
            FacesMessage m = new FacesMessage("Login erfolgreich");
            fc.addMessage(null, m);
            
            //Holen der aktuellen Session
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false); // keine neue Session erstellen
            us.setLoggedIn(true); // boolean zur Überprüfung wird auf true gesetzt. 
            s.setMaxInactiveInterval(600); // Die lebensdauer der Session in Sekunden
            return "/signedIn.xhtml?faces-redirect=true"; // SignedIn wird aufgerufen.
        } else { // wenn der Benutzer nicht vorhanden ist wird eine entsprechende Facesmessage erzeugt.

            fc = FacesContext.getCurrentInstance();
            fc.addMessage("test", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnung", "Der Benutzer konnte nicht gefunden werden"));

        }

        return null; //Es wird keine andere Seite aufgerufen. --> page refresh

    }
    
    
}

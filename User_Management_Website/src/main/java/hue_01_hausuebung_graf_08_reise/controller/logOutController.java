/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * Dieser Controller ist für den LogOut zuständig
 * @author graff
 */
@Named
@RequestScoped
public class logOutController implements Serializable{
    
    @Inject
    private UserController us;
    /**
     * Diese Methode wird aufgerofen wenn sich der Benutzer ausloggt. 
     * @param benutzer
     * @return
     */
    public String logOut() {
        
        //holen der aktuellen Session.
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        s.invalidate(); 
        FacesContext fc = FacesContext.getCurrentInstance();
        //eine entsprechende Meldung erzeugen
        fc.addMessage(null, new FacesMessage("Sie wurden abgemeldet"));
        us.setLoggedIn(false); // Abfageboolean auf false setzen.
        return "signIn.xhtml?faces-redirect=true"; //die Seite die aufgerufen wird
    }
}

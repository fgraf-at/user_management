/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.controller;

import hue_01_hausuebung_graf_08_reise.db.IDAO;
import hue_01_hausuebung_graf_08_reise.model.Benutzer;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Dieser Controller dient der Registrierung eines neuen Benutzers
 * @author graff
 */
@Named(value = "signUpController")
@RequestScoped
public class SignUpController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private IDAO dao;
    @Inject
    private UserController us;

    @PostConstruct
    private void init() {
        
    }

    /**
     * Diese Methode ist für das Anmelden zuständig. Der Benutzer wird in der Datenbank
     * gespeichert. es wird eine Entsprechende Facesmessage erzeugt.
     * @return
     */
    public String signUp() {

        FacesContext context = FacesContext.getCurrentInstance();
        if (dao.saveBenutzer(us.getBenutzer())) {

            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, "Erfolg", "Speichern erfolgreich"));
            return "/signIn.xhtml";
        } else {
            context.addMessage("msg2", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnung", "Benutzer konnte nicht gespeichert werden"));

            return null;
        }

    }

}

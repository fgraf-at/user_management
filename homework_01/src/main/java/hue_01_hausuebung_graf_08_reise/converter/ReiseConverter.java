/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.converter;

import hue_01_hausuebung_graf_08_reise.db.IDAO;
import hue_01_hausuebung_graf_08_reise.model.Reisetyp;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/**
 * Dieser Konvertiert ist für die Reisetypen zuständig.
 * @author graff
 */
@Named(value = "reiseConverter")
@ApplicationScoped
public class ReiseConverter implements Converter {

    @EJB
    private IDAO dao;
    /**
     * getAsObject vergleicht die Bezeichnung mit der Bezeichnung aller Objekte. 
     * Gibt es eine Übereinstimmung wird das entsprechende Objekt zurückgegeben.
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
       
        if(value.equals(dao.getReisetypFromId(value))){// mit Equals werden die Strings auf gleichheit geprüft  
            return value;
        }
        
        throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Reisetyp", "Reisetyp kann nicht Convertiert werden"));
    }
    /**
     * Die Bezeichnung des Objektes wird als String zurückgegeben. Wird auf der Website 
     * angezeigt und wird außerdem zum vergleichen in der getAsObject gebraucht. 
     * @param context
     * @param component
     * @param value
     * @return Die Bezeichnung des Objektes
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Reisetyp r = (Reisetyp) value; //Casten in den Reisetyp
        
        return Integer.toString(r.getId()); //Holen der Bezeichnung
    }

}

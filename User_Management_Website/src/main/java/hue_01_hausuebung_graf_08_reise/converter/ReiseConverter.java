/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.converter;

import hue_01_hausuebung_graf_08_reise.db.IDAO;
import hue_01_hausuebung_graf_08_reise.model.Benutzer;
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
         
        int intVal = Integer.parseInt(value);
        try{
            System.out.println("hier in converter " + intVal);
            Reisetyp b = dao.getReisetypFromID(intVal);
            if(b!=null){
               return b;
            }
             throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Reisetyp", "Benutzer kann nicht konvertiert werden"));
        
            
        }catch(Exception e){   
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Reisetyp", e.getMessage()));
        }
        
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
        return Integer.toString(r.getId()); 
    }

}

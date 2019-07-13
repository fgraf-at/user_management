/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.listener;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author graff
 */
public class HttpListener implements HttpSessionAttributeListener{
 private boolean create = true;
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
 
         Object o = null;
         
        if ((o = event.getSession().getAttribute("new")) != null) {
           
            System.out.println("O: " + o);
            System.out.println("AttributeAdded");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage("test", new FacesMessage(FacesMessage.SEVERITY_INFO,"Abgemeldet", "Sie wurden wegen Inaktivität abgemeldet."));
           
            
             
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
       
    }

    
    
}

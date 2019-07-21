/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener1;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author graff
 */
public class SessionListener implements PhaseListener {

    private static final long serialVersionUID = 1L;
    private boolean add=false;
    @Override
    public void afterPhase(PhaseEvent event) {
      
      
    }

    @Override
    public void beforePhase(PhaseEvent event) {
//          HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//         HttpSession httpsession = (HttpSession) event.getFacesContext().getExternalContext().getSession(false);
//        
//        System.out.println(req.getRequestURI());
//        if ((!req.getRequestURI().equals("/HUE_01_Hausuebung_Graf_08_Reise/") && !req.getRequestURI().equals("/HUE_01_Hausuebung_Graf_08_Reise/faces/signIn.xhtml"))) {
//            if (httpsession == null) {
//                try {
//                    System.out.println("redirect");
//                    FacesContext fc1 = FacesContext.getCurrentInstance();
//                    
//                    fc1.getExternalContext().redirect("expired.xhtml");
//                  
//                } catch (IOException ioe) {
//                    ioe.printStackTrace();
//                }
//
//            }
//        }
//       

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}

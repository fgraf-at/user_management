/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.db;

import hue_01_hausuebung_graf_08_reise.model.Benutzer;
import hue_01_hausuebung_graf_08_reise.model.Reisetyp;
import hue_01_hausuebung_graf_08_reise.model.Reiseveranstaltung;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Datenbankzugriffsklasse. Diese Klasse beinhaltet alle wichtigen Methoden für
 * Datenbankzugriffe
 * @author graff
 */
@Stateless
public class DAO implements IDAO {

    @PersistenceContext
    private EntityManager em;
    /**
     * Methode um sich einen Benutzer aus der Datenbank zu holen.
     * @param b Der zu Persistierende Benutzer
     * @return Der gefundene Benutzer
     */
    @Override
    public Benutzer getBenutzer(Benutzer b) {
        Benutzer benutzer = null;
        if ((benutzer = em.find(Benutzer.class, b.getEmail())) != null) {
            return benutzer;      
        } else {
            return null;
        }
    }
     

    /**
     * Methode, um sich alle Benutzer aus der Datenbank zu holen
     * @return Eine Liste Aller Benutzer der Datenbank
     */
    @Override
    public List<Benutzer> getAllBenutzer() {
        try {
            TypedQuery<Benutzer> tq = em.createQuery("select b from Benutzer b ", Benutzer.class);
            em.createQuery("select b. from Reisetyp b", Benutzer.class);
            return tq.getResultList();
        } catch (Exception e) {
            //Bei einem Fehler wird die Exception behandelt und eine Meldung ausgegeben
            System.err.println("Fehler in getAllBenutzer: " + e.getMessage());
            return null;
        }

    }

    /**
     * Methode, um einen Benutzer in der Datenbank zu speichern.
     * @param b
     * @return 
     */
    @Override
    public boolean saveBenutzer(Benutzer b) {
       Benutzer benutzer = null;
        if (b.getEmail() != null) {
            benutzer = em.find(Benutzer.class, b.getEmail());
            
        }
        if (benutzer == null ) {
            System.out.println("saveBenutzer: " + b);
            em.persist(b);
            return true;
        } else {
            return false;
        }

    }
      @Override
    public boolean mergeBenutzer(Benutzer b) {
       Benutzer benutzer = null;
        if (b.getEmail() != null) {
            benutzer = em.find(Benutzer.class, b.getEmail());
            
        }
        if (benutzer != null ) {
            em.merge(b);
            return true;
        } else {
            return false;
        }

    }

    /**
     * 
     * @return 
     */
    @Override
    public List<Reisetyp> getAllReisetypen() {
       try {
            TypedQuery<Reisetyp> tq = em.createQuery("select r from Reisetyp r ", Reisetyp.class);
            
            return tq.getResultList();
        } catch (Exception e) {
            System.err.println("Fehler in getAllBenutzer: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reiseveranstaltung> getAllReiseveranstaltungen() {
        try {
            TypedQuery<Reiseveranstaltung> tq = em.createQuery("select r from Reiseveranstaltung r ", Reiseveranstaltung.class);   
            return tq.getResultList();
        } catch (Exception e) {
            System.err.println("Fehler in getAllBenutzer: " + e.getMessage());
            return null;
        }
    }

    /**
     * Diese Methode validiert den Benutzer und das Passwort
     * @return true wenn Benutzer und Passwort stimmen
     */
    @Override
    public boolean validate(Benutzer b) {
         try {
             System.out.println("validate: " + b);
            TypedQuery<Benutzer> tq = em.createQuery("select b from Benutzer b where b.email = :mail AND b.passwort = :pw", Benutzer.class);   
            tq.setParameter("mail", b.getEmail());
            tq.setParameter("pw", b.getPasswort());
            if(tq.getSingleResult()!=null){
                return true;             
            }else{
                return false;
            }
             
        }catch(NoResultException nre){
             System.err.println("Kein Element gefunden: " + nre.getMessage());
             return false;
        }
         catch (Exception e) {
            System.err.println("Fehler in getAllBenutzer: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Reisetyp getReisetypFromId(String value) {
        try {
            TypedQuery<Reisetyp> tq = em.createQuery("select r from Reisetyp r where r.id = valP", Reisetyp.class)
                    .setParameter("valP", value);
            
            return tq.getSingleResult();
        } catch (Exception e) {
            System.err.println("Fehler in getIdFromReisetyp: " + e.getMessage());
            return null;
        }
    }
    
    
}

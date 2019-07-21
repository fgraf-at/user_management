/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise_client.dao;

import hue_01_hausuebung_graf_08_reise_client.model.Benutzer;
import hue_01_hausuebung_graf_08_reise_client.model.Reisetyp;
import hue_01_hausuebung_graf_08_reise_client.model.Reiseveranstaltung;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author graff
 */
public class DAO implements AutoCloseable {

    private final static DAO INSTANCE = new DAO();

    private DAO() {
    }

    public static DAO getINSTANCE() {
        return INSTANCE;
    }

    public boolean persist(Reisetyp reisetyp) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(reisetyp);
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            return false;
        } finally {

            em.close();
        }
    }
 public boolean persist(Benutzer benutzer) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(benutzer);
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            return false;
        } finally {

            em.close();
        }
    }
 public boolean persist(Reiseveranstaltung reiseveranstaltung) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(reiseveranstaltung);
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            return false;
        } finally {

            em.close();
        }
    }
    @Override
    public void close() {
        JPAUtil.close();
    }
}

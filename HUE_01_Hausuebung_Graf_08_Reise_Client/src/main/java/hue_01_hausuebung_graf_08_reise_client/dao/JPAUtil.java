/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise_client.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author graff
 */
public class JPAUtil {

    private static final EntityManagerFactory EMF;

    static {
        try {
            EMF = Persistence.createEntityManagerFactory("20140056_HUE_01_Hausuebung_Graf_08_Reise_Client_jar_1.0PU");
        } catch (Exception ex) {
            System.err.println("EntityManagerFactory creation faild: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEMF() {
        return EMF;
    }

    public static void close() {
        EMF.close();
    }
}

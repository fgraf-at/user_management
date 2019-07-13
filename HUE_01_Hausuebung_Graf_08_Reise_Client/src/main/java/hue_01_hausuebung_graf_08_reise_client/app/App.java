/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise_client.app;

import hue_01_hausuebung_graf_08_reise_client.dao.DAO;
import hue_01_hausuebung_graf_08_reise_client.model.Benutzer;
import hue_01_hausuebung_graf_08_reise_client.model.Reisetyp;
import hue_01_hausuebung_graf_08_reise_client.model.Reiseveranstaltung;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author graff
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Reisetyp r1 = new Reisetyp("Städtereisen");
        Reisetyp r2 = new Reisetyp("Italien");
        Reisetyp r3 = new Reisetyp("Last Minute");
        Reisetyp[] rArr = {r1, r2, r3};

        Reiseveranstaltung rv1 = new Reiseveranstaltung("Wien", "Tagesausflug", new GregorianCalendar(2018, Calendar.FEBRUARY, 12).getTime(),
                 new GregorianCalendar(2018, Calendar.FEBRUARY, 12).getTime(), 100, "https://de.wikipedia.org/wiki/Wien", r1);
        Reiseveranstaltung rv2 = new Reiseveranstaltung("Rom", "Italienausflug", new GregorianCalendar(2018, Calendar.SEPTEMBER, 10).getTime(),
                 new GregorianCalendar(2018, Calendar.SEPTEMBER, 16).getTime(), 820, null,r2);
        Reiseveranstaltung rv3 = new Reiseveranstaltung("Paris", "Letztes Angebot", new GregorianCalendar(2018, Calendar.OCTOBER, 20).getTime(),
                 new GregorianCalendar(2018, Calendar.SEPTEMBER, 24).getTime(), 350, null,r3);
          Reiseveranstaltung rv4 = new Reiseveranstaltung("Paris", "Günstiges Angebot jetzt zuschlagen", new GregorianCalendar(2018, Calendar.OCTOBER, 24).getTime(),
                 new GregorianCalendar(2018, Calendar.JULY, 24).getTime(), 350, null,r3);
        Reiseveranstaltung[] rvArr = {rv1, rv2, rv3, rv4};
        // TODO code application logic here
        Benutzer b1 = new Benutzer("graf.felix@aon.at", "Felix", "Graf", "123456", false);
        b1.setReisetyp(Arrays.asList(r1, r3));
        Benutzer b2 = new Benutzer("hagmann.fabian@gmx.net", "Fabian", "Hagmann", "654321", false);
        b2.setReisetyp(Arrays.asList(r2));
        Benutzer b3 = new Benutzer("tobias.frommhund@gmx.at", "Tobias", "Frommhund", "456321", true);
        b3.setReisetyp(Arrays.asList(r1, r2, r3));
        Benutzer[] bArr = {b1, b2, b3};

        try (DAO dao = DAO.getINSTANCE()) {
            
            System.out.println("Persistieren von Reisetypen:");
            for (Reisetyp r : rArr) {
                if (dao.persist(r)) {
                    System.out.println(r + " erfolgreich persistiert");
                }

            }
            System.out.println("Persistieren von Reiseveranstaltungen:");
            for (Reiseveranstaltung rv: rvArr) {
                if (dao.persist(rv)) {
                    System.out.println(rv + " erfolgreich persistiert");
                }

            }
            System.out.println("Persistieren von Benutzern:");
            for (Benutzer b : bArr) {

                if (dao.persist(b)) {
                    System.out.println(b + " erfolgreich persistiert");
                }

            }

            System.out.println("Daten wurden erfolgreich gespeichert;");

        }
    }

}

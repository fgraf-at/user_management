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
import javax.ejb.Local;

/**
 *
 * @author graff
 */
@Local //keine Userabhängigen Daten
public interface IDAO {
    public Benutzer getBenutzer(Benutzer b);
    public List<Benutzer> getAllBenutzer();
    public List<Reisetyp> getAllReisetypen();
    public List<Reiseveranstaltung> getAllReiseveranstaltungen();
    public boolean saveBenutzer(Benutzer b); 
    public boolean validate(Benutzer b);
    public boolean mergeBenutzer(Benutzer b);
    public Reisetyp getReisetypFromID(int id) throws RuntimeException;
}


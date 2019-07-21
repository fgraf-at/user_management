package hue_01_hausuebung_graf_08_reise.model;

import hue_01_hausuebung_graf_08_reise.model.Reisetyp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T23:30:34")
@StaticMetamodel(Reiseveranstaltung.class)
public class Reiseveranstaltung_ { 

    public static volatile SingularAttribute<Reiseveranstaltung, String> hyperlink;
    public static volatile SingularAttribute<Reiseveranstaltung, Double> preis;
    public static volatile SingularAttribute<Reiseveranstaltung, Date> ende;
    public static volatile SingularAttribute<Reiseveranstaltung, Integer> id;
    public static volatile SingularAttribute<Reiseveranstaltung, String> zielort;
    public static volatile SingularAttribute<Reiseveranstaltung, String> beschreibung;
    public static volatile SingularAttribute<Reiseveranstaltung, Date> beginn;
    public static volatile SingularAttribute<Reiseveranstaltung, Reisetyp> reisetyp;

}
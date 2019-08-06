package user_management_webservice.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import user_management_webservice.model.Reisetyp;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-16T14:50:35")
@StaticMetamodel(Reiseveranstaltung.class)
public class Reiseveranstaltung_ { 

    public static volatile SingularAttribute<Reiseveranstaltung, String> hyperlink;
    public static volatile SingularAttribute<Reiseveranstaltung, Double> preis;
    public static volatile SingularAttribute<Reiseveranstaltung, Reisetyp> reisetypReiseveranstaltungId;
    public static volatile SingularAttribute<Reiseveranstaltung, Date> ende;
    public static volatile SingularAttribute<Reiseveranstaltung, Integer> id;
    public static volatile SingularAttribute<Reiseveranstaltung, String> zielort;
    public static volatile SingularAttribute<Reiseveranstaltung, String> beschreibung;
    public static volatile SingularAttribute<Reiseveranstaltung, Date> beginn;

}
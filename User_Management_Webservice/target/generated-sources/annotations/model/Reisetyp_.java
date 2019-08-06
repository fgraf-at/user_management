package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Benutzer;
import model.Reiseveranstaltung;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-13T23:51:45")
@StaticMetamodel(Reisetyp.class)
public class Reisetyp_ { 

    public static volatile SingularAttribute<Reisetyp, String> bezeichnung;
    public static volatile SingularAttribute<Reisetyp, Integer> id;
    public static volatile CollectionAttribute<Reisetyp, Benutzer> benutzerCollection;
    public static volatile CollectionAttribute<Reisetyp, Reiseveranstaltung> reiseveranstaltungCollection;

}
package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Reisetyp;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-10T17:34:21")
@StaticMetamodel(Benutzer.class)
public class Benutzer_ { 

    public static volatile SingularAttribute<Benutzer, Boolean> newsletter;
    public static volatile SingularAttribute<Benutzer, String> passwort;
    public static volatile CollectionAttribute<Benutzer, Reisetyp> reisetypCollection;
    public static volatile SingularAttribute<Benutzer, String> email;

}
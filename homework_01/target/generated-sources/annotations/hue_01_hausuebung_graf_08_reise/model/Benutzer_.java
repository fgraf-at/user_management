package hue_01_hausuebung_graf_08_reise.model;

import hue_01_hausuebung_graf_08_reise.model.Reisetyp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-11T00:33:37")
@StaticMetamodel(Benutzer.class)
public class Benutzer_ { 

    public static volatile SingularAttribute<Benutzer, Boolean> newsletter;
    public static volatile SingularAttribute<Benutzer, String> passwort;
    public static volatile SingularAttribute<Benutzer, String> email;
    public static volatile ListAttribute<Benutzer, Reisetyp> reisetyp;

}
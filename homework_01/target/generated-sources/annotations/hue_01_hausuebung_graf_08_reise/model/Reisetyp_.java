package hue_01_hausuebung_graf_08_reise.model;

import hue_01_hausuebung_graf_08_reise.model.Reiseveranstaltung;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T23:30:34")
@StaticMetamodel(Reisetyp.class)
public class Reisetyp_ { 

    public static volatile SingularAttribute<Reisetyp, String> bezeichnung;
    public static volatile ListAttribute<Reisetyp, Reiseveranstaltung> reiseveranstaltung;
    public static volatile SingularAttribute<Reisetyp, Integer> id;

}
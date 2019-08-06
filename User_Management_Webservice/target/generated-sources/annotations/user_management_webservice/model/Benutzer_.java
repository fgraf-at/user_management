package user_management_webservice.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import user_management_webservice.model.Reisetyp;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-16T14:50:35")
@StaticMetamodel(Benutzer.class)
public class Benutzer_ { 

    public static volatile SingularAttribute<Benutzer, Boolean> newsletter;
    public static volatile SingularAttribute<Benutzer, String> passwort;
    public static volatile SingularAttribute<Benutzer, String> surname;
    public static volatile SingularAttribute<Benutzer, String> name;
    public static volatile CollectionAttribute<Benutzer, Reisetyp> reisetypCollection;
    public static volatile SingularAttribute<Benutzer, String> email;

}
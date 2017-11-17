package entity;

import entity.Myitem;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-24T21:16:40")
@StaticMetamodel(Gamedeveloper.class)
public class Gamedeveloper_ { 

    public static volatile SingularAttribute<Gamedeveloper, Integer> id;
    public static volatile CollectionAttribute<Gamedeveloper, Myitem> myitemCollection;
    public static volatile SingularAttribute<Gamedeveloper, String> dName;

}
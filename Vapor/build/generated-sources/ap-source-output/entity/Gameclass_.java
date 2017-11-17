package entity;

import entity.Myitem;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-24T21:16:40")
@StaticMetamodel(Gameclass.class)
public class Gameclass_ { 

    public static volatile SingularAttribute<Gameclass, Integer> id;
    public static volatile CollectionAttribute<Gameclass, Myitem> myitemCollection;
    public static volatile SingularAttribute<Gameclass, String> cName;

}
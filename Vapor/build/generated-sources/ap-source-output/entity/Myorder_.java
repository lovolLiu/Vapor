package entity;

import entity.Myuser;
import entity.OrderItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-24T21:16:40")
@StaticMetamodel(Myorder.class)
public class Myorder_ { 

    public static volatile SingularAttribute<Myorder, Integer> id;
    public static volatile SingularAttribute<Myorder, Date> time;
    public static volatile CollectionAttribute<Myorder, OrderItem> orderItemCollection;
    public static volatile SingularAttribute<Myorder, Myuser> userId;
    public static volatile SingularAttribute<Myorder, Integer> state;

}
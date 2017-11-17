package entity;

import entity.Myitem;
import entity.Myorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-24T21:16:40")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Myitem> myItemid;
    public static volatile SingularAttribute<OrderItem, Myorder> myOrderid;
    public static volatile SingularAttribute<OrderItem, Integer> orderItemid;

}
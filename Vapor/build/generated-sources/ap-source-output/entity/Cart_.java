package entity;

import entity.Myitem;
import entity.Myuser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-24T21:16:40")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, Myitem> myItemid;
    public static volatile SingularAttribute<Cart, Integer> cartid;
    public static volatile SingularAttribute<Cart, Myuser> myUserid;

}
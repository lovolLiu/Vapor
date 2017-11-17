package entity;

import entity.Cart;
import entity.Gameclass;
import entity.Gamedeveloper;
import entity.Gamepicture;
import entity.OrderItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-24T21:16:40")
@StaticMetamodel(Myitem.class)
public class Myitem_ { 

    public static volatile SingularAttribute<Myitem, Integer> id;
    public static volatile SingularAttribute<Myitem, Date> pubTime;
    public static volatile CollectionAttribute<Myitem, Cart> cartCollection;
    public static volatile CollectionAttribute<Myitem, Gamepicture> gamepictureCollection;
    public static volatile SingularAttribute<Myitem, Gamedeveloper> gameDeveloperid;
    public static volatile SingularAttribute<Myitem, Float> price;
    public static volatile CollectionAttribute<Myitem, OrderItem> orderItemCollection;
    public static volatile SingularAttribute<Myitem, String> description;
    public static volatile SingularAttribute<Myitem, String> name;
    public static volatile SingularAttribute<Myitem, Gameclass> gameClassid;
    public static volatile SingularAttribute<Myitem, Integer> timesOfBuy;

}
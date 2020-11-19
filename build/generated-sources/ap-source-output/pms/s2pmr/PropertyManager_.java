package pms.s2pmr;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pms.s1pmt.Property;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T18:19:32")
@StaticMetamodel(PropertyManager.class)
public class PropertyManager_ { 

    public static volatile SingularAttribute<PropertyManager, String> pmLastName;
    public static volatile SingularAttribute<PropertyManager, String> pmMobileNumber;
    public static volatile SingularAttribute<PropertyManager, String> pmEmail;
    public static volatile ListAttribute<PropertyManager, Property> property;
    public static volatile SingularAttribute<PropertyManager, Long> pmid;
    public static volatile SingularAttribute<PropertyManager, String> pmFirstName;
    public static volatile SingularAttribute<PropertyManager, String> pmPhoneNumber;

}
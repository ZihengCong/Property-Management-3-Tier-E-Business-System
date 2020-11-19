package pms.s2pmr;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import pms.s1pmt.Property;


@Entity
@NamedQueries({
    @NamedQuery(name = "findAllPropertyManagers", query = "SELECT m FROM PropertyManager m"),
    @NamedQuery(name = "searchPropertyManager", query = "SELECT m FROM PropertyManager m WHERE m.pmFirstName = :fname AND m.pmLastName = :lname"),
})
public class PropertyManager{

    //Attributes
    @Id 
    @GeneratedValue
    private Long pmid;
    private String pmFirstName;
    private String pmLastName;
    private String pmPhoneNumber;
    private String pmMobileNumber;
    private String pmEmail;
    @OneToMany
    @JoinColumn(name = "propertyManager_FK")
    private List<Property> property;
   
    
    //Constructors
    public PropertyManager() {
    }

    public PropertyManager(String pmFirstName, String pmLastName, String pmPhoneNumber, String pmMobileNumber, String pmEmail) {
        this.pmFirstName = pmFirstName;
        this.pmLastName = pmLastName;
        this.pmPhoneNumber = pmPhoneNumber;
        this.pmMobileNumber = pmMobileNumber;
        this.pmEmail = pmEmail;
    }
    
    //Getters & Setters
    public Long getPmid() {
        return pmid; 
    }

    public String getPmFirstName() {
        return pmFirstName;
    }

    public void setPmFirstName(String pmFirstName) {
        this.pmFirstName = pmFirstName;
    }

    public String getPmLastName() {
        return pmLastName;
    }

    public void setPmLastName(String pmLastName) {
        this.pmLastName = pmLastName;
    }

    public String getPmPhoneNumber() {
        return pmPhoneNumber;
    }

    public void setPmPhoneNumber(String pmPhoneNumber) {
        this.pmPhoneNumber = pmPhoneNumber;
    }

    public String getPmMobileNumber() {
        return pmMobileNumber;
    }

    public void setPmMobileNumber(String pmMobileNumber) {
        this.pmMobileNumber = pmMobileNumber;
    }

    public String getPmEmail() {
        return pmEmail;
    }

    public void setPmEmail(String pmEmail) {
        this.pmEmail = pmEmail;
    }

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

}

package pms.s1pmt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "findAllProperties", query = "SELECT i FROM Property i"),
    @NamedQuery(name = "findAllSaleProperties", query = "SELECT c FROM SaleProperty c WHERE c.salePrice is not NULL"),
    @NamedQuery(name = "findAllRentProperties", query = "SELECT c FROM RentProperty c WHERE c.weeklyRent is not NULL"),
    @NamedQuery(name = "searchSaleProperty", query = "SELECT c FROM SaleProperty c WHERE c.id = :id"),
    @NamedQuery(name = "searchRentProperty", query = "SELECT c FROM RentProperty c WHERE c.id = :id")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Property {

    //Attributes    
    @Id
    @GeneratedValue
    private Long id;
    private String propertyType;
    private Integer nbOfBedrooms;
    private Integer nbOfBathrooms;
    @Column(length = 2000)
    private String description;
    private Integer streetNumber;
    private String streetName;
    private String city;
    private Integer postcode;
    private String country;


    //Constructors
    public Property() {
    }

    public Property(String propertyType, Integer nbOfBedrooms, Integer nbOfBathrooms, String description, Integer streetNumber, String streetName, String city, Integer postcode, String country) {
        this.propertyType = propertyType;
        this.nbOfBedrooms = nbOfBedrooms;
        this.nbOfBathrooms = nbOfBathrooms;
        this.description = description;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }
    
    //Getters & Setters 
    public Long getId() {
        return id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getNbOfBedrooms() {
        return nbOfBedrooms;
    }

    public void setNbOfBedrooms(Integer nbOfBedrooms) {
        this.nbOfBedrooms = nbOfBedrooms;
    }

    public Integer getNbOfBathrooms() {
        return nbOfBathrooms;
    }

    public void setNbOfBathrooms(Integer nbOfBathrooms) {
        this.nbOfBathrooms = nbOfBathrooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

package pms.s1pmt;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class RentProperty extends Property {

    //Attributes
    @Column(nullable = false)
    private Integer weeklyRent;  
    private Boolean furnished;
    
    //Constructors
    public RentProperty() {
    }

    public RentProperty(Integer weeklyRent, Boolean furnished) {
        this.weeklyRent = weeklyRent;
        this.furnished = furnished;
    }
    
    //Getters & Setters
    public Integer getWeeklyRent() {
        return weeklyRent;
    }

    public void setWeeklyRent(Integer weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    public Boolean getFurnished() {
        return furnished;
    }

    public void setFurnished(Boolean furnished) {
        this.furnished = furnished;
    }
    
    
}

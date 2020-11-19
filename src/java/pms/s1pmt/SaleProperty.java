package pms.s1pmt;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class SaleProperty extends Property {

    //Attributes
    @Column(nullable = false)
    private Integer salePrice; 
    
    //Constructors
    public SaleProperty() {
    }

    public SaleProperty(Integer salePrice, Long searchID) {
        this.salePrice = salePrice;
    }
    
    //Getters & Setters
    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

}

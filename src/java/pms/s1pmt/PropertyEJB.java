package pms.s1pmt;

import java.sql.ResultSet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import pms.s2pmr.PropertyManager;


@Stateless
public class PropertyEJB {

    //Attributes             
    @PersistenceContext(unitName = "PropertyManagementSystemPU")
    private EntityManager em;
    
    //Public methods     
    public List<SaleProperty> findSaleProperties() {
        Query query = em.createNamedQuery("findAllSaleProperties");
        return query.getResultList();
    }
    
    public List<RentProperty> findRentProperties() {
        Query query = em.createNamedQuery("findAllRentProperties");
        return query.getResultList();
    }
    
    public List<PropertyManager> findPropertyManager(){
        Query query = em.createNamedQuery("findAllPropertyManagers");
        return query.getResultList();
    }
   
    public List<SaleProperty> searchSaleProperties(Long parameter) {
        TypedQuery<SaleProperty> query = em.createNamedQuery("searchSaleProperty", SaleProperty.class);
        query.setParameter("id",parameter); 
        List<SaleProperty> searchSaleList = query.getResultList();
        return searchSaleList;
    }
    
    public List<RentProperty> searchRentProperties(Long parameter) {
        TypedQuery<RentProperty> query = em.createNamedQuery("searchRentProperty", RentProperty.class);
        query.setParameter("id",parameter); 
        List<RentProperty> searchRentList = query.getResultList();
        return searchRentList;
    }
    
    public List<PropertyManager> searchManagerProperties(String firstname, String lastname) {
        TypedQuery<PropertyManager> query = em.createNamedQuery("searchPropertyManager", PropertyManager.class);
        query.setParameter("fname",firstname); 
        query.setParameter("lname",lastname); 
        List<PropertyManager> searchRentList = query.getResultList();
        return searchRentList;
    }
    
    public SaleProperty createSaleProperty(SaleProperty saleproperty) {
        em.persist(saleproperty);
        return saleproperty;
    }
    
    public RentProperty createRentProperty(RentProperty rentproperty) {
        em.persist(rentproperty);
        return rentproperty;
    }
    
    public PropertyManager createPropertyManager(PropertyManager propertymanager){
        em.persist(propertymanager);
        return propertymanager;
    }
    
}

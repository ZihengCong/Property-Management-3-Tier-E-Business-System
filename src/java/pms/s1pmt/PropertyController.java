package pms.s1pmt;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import pms.s2pmr.PropertyManager;


@ManagedBean(name = "myPropertyController")
@RequestScoped
public class PropertyController {

    //Attributes 
    @EJB
    private PropertyEJB propertyEJB;
    private SaleProperty saleproperty = new SaleProperty();
    private RentProperty rentproperty = new RentProperty();
    private PropertyManager propertymanager = new PropertyManager();
    private Property property = new Property();
    private List<SaleProperty> propertySaleList = new ArrayList<SaleProperty>();
    private List<RentProperty> propertyRentList = new ArrayList<RentProperty>();
    private List<PropertyManager> propertyManagerList = new ArrayList<PropertyManager>();
    //For searching
    private List<SaleProperty> searchSaleList = new ArrayList<SaleProperty>();
    private List<RentProperty> searchRentList = new ArrayList<RentProperty>();
    private List<PropertyManager> searchPropertyManagerList = new ArrayList<PropertyManager>();
    private Long searchID;
    private String searchFirstName;
    private String searchLastName;
    private Long viewDetailsID;
    //For allocation
    private String allocationManagerName; //values chose by drop down list and store here
    private String allocationSaleProperty;
    private String allocationRentProperty;
    private List<SaleProperty> allocationSaleSection = new ArrayList<SaleProperty>();
    private List<RentProperty> allocationRentSection = new ArrayList<RentProperty>();
    
    
    //Public methods
    public String doNewSaleProperty() {
        return "newSaleProperty.xhtml";
    }

    public String doNewRentProperty() {
        return "newRentProperty.xhtml";
    }
    
    public String doNewPropertyManager() {
        return "newPropertyManager.xhtml";
    }
    
    //New Create Section
    public String doCreateSaleProperty() {
        saleproperty = propertyEJB.createSaleProperty(saleproperty);
        propertySaleList = propertyEJB.findSaleProperties();
        return "listSaleProperties.xhtml";
    }
    
    public String doCreateRentProperty() {
        rentproperty = propertyEJB.createRentProperty(rentproperty);
        propertyRentList = propertyEJB.findRentProperties();
        return "listRentProperties.xhtml";
    }
    
    public String doCreatePropertyManager() {
        propertymanager = propertyEJB.createPropertyManager(propertymanager);
        propertyManagerList = propertyEJB.findPropertyManager();
        return "listPropertyManager.xhtml";
    }
    
    //Search Section
    public String doSearchSaleProperty(){
        searchSaleList = propertyEJB.searchSaleProperties(searchID);
        return "searchSaleResult.xhtml";
    }
    
    public String doSearchRentProperty(){
        searchRentList = propertyEJB.searchRentProperties(searchID);
        return "searchRentResult.xhtml";
    }
    
    public String doSearchManagerProperty(){
        searchPropertyManagerList = propertyEJB.searchManagerProperties(searchFirstName, searchLastName);
        return "searchPropertyManagerResult.xhtml";
    }
    
    //View Details Section
    public String doViewSaleDetails(Long viewID){
        searchSaleList = propertyEJB.searchSaleProperties(viewID);
        return "viewSaleDetails.xhtml";
    }
    
    public String doViewRentDetails(Long viewID){
        searchRentList = propertyEJB.searchRentProperties(viewID);
        return "viewRentDetails.xhtml";
    }
    
    public String doViewManagerDetails(String fname, String lname){
        searchPropertyManagerList = propertyEJB.searchManagerProperties(fname, lname);
        return "viewPropertyManagerDetails.xhtml";
    }
    
    //---------------------------Create Allocation------------------------------
    /**
     * Each method downbelow for example 'doAllocateSaleProperty' will first call
     * method in 'PropertyEJB' to query database. Then receive the return list from
     * method in EJB and then in this method return the web page of result.
     * 
     */
//    //Allocation Section
//    public String doAllocateSaleProperty(String managerName, String saleAllocation){
//        allocationSaleSection =  propertyEJB.allocationSaleProperty(managerName, saleAllocation);
//        return "";
//    }
//    
//    public String doAllocateRentProperty(String managerName, String rentAllocation){
//        allocationRentSection = propertyEJB.allocationRentProperty(managerName, rentAllocation);
//        return "";
//    }
    
    
    //Getters & Setters
    public SaleProperty getSaleproperty() {
        return saleproperty;
    }

    public void setSaleproperty(SaleProperty saleproperty) {
        this.saleproperty = saleproperty;
    }

    public RentProperty getRentproperty() {
        return rentproperty;
    }

    public void setRentproperty(RentProperty rentproperty) {
        this.rentproperty = rentproperty;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<SaleProperty> getPropertySaleList() {
        propertySaleList = propertyEJB.findSaleProperties();
        return propertySaleList;
    }

    public void setPropertySaleList(List<SaleProperty> propertySaleList) {
        this.propertySaleList = propertySaleList;
    }

    public List<RentProperty> getPropertyRentList() {
        propertyRentList = propertyEJB.findRentProperties();
        return propertyRentList;
    }

    public void setPropertyRentList(List<RentProperty> propertyRentList) {
        this.propertyRentList = propertyRentList;
    }

    public PropertyManager getPropertymanager() {
        return propertymanager;
    }

    public void setPropertymanager(PropertyManager propertymanager) {
        this.propertymanager = propertymanager;
    }

    public List<PropertyManager> getPropertyManagerList() {
        propertyManagerList = propertyEJB.findPropertyManager();  //
        return propertyManagerList;
    }

    public void setPropertyManagerList(List<PropertyManager> propertyManagerList) {
        this.propertyManagerList = propertyManagerList;
    }


    public List<SaleProperty> getSearchSaleList() {
        return searchSaleList;
    }

    public void setSearchSaleList(List<SaleProperty> searchSaleList) {
        this.searchSaleList = searchSaleList;
    }

    public List<RentProperty> getSearchRentList() {
        return searchRentList;
    }

    public void setSearchRentList(List<RentProperty> searchRentList) {
        this.searchRentList = searchRentList;
    }

    public List<PropertyManager> getSearchPropertyManagerList() {
        return searchPropertyManagerList;
    }

    public void setSearchPropertyManagerList(List<PropertyManager> searchPropertyManagerList) {
        this.searchPropertyManagerList = searchPropertyManagerList;
    }
    
    
    public Long getSearchID() {
        return searchID;
    }

    public void setSearchID(Long searchID) {
        this.searchID = searchID;
    }

    public String getSearchFirstName() {
        return searchFirstName;
    }

    public void setSearchFirstName(String searchFirstName) {
        this.searchFirstName = searchFirstName;
    }

    public String getSearchLastName() {
        return searchLastName;
    }

    public void setSearchLastName(String searchLastName) {
        this.searchLastName = searchLastName;
    }

    public Long getViewDetailsID() {
        return viewDetailsID;
    }

    public void setViewDetailsID(Long viewDetailsID) {
        this.viewDetailsID = viewDetailsID;
    }

    public String getAllocationManagerName() {
        return allocationManagerName;
    }

    public void setAllocationManagerName(String allocationManagerName) {
        this.allocationManagerName = allocationManagerName;
    }

    public String getAllocationSaleProperty() {
        return allocationSaleProperty;
    }

    public void setAllocationSaleProperty(String allocationSaleProperty) {
        this.allocationSaleProperty = allocationSaleProperty;
    }

    public String getAllocationRentProperty() {
        return allocationRentProperty;
    }

    public void setAllocationRentProperty(String allocationRentProperty) {
        this.allocationRentProperty = allocationRentProperty;
    }

    public List<SaleProperty> getAllocationSaleSection() {
        return allocationSaleSection;
    }

    public void setAllocationSaleSection(List<SaleProperty> allocationSaleSection) {
        this.allocationSaleSection = allocationSaleSection;
    }

    public List<RentProperty> getAllocationRentSection() {
        return allocationRentSection;
    }

    public void setAllocationRentSection(List<RentProperty> allocationRentSection) {
        this.allocationRentSection = allocationRentSection;
    }

    
}

package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Company  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String address;
     private Integer phone;
     private String email;
     private Date registrationdate;
     private int cuit;
     private Set companyschedules = new HashSet(0);

    public Company() {
    }

	
    public Company(String name, String address, int cuit) {
        this.name = name;
        this.address = address;
        this.cuit = cuit;
    }
    public Company(String name, String address, Integer phone, String email, int cuit, Set companyschedules) {
       this.name = name;
       this.address = address;
       this.phone = phone;
       this.email = email;
       this.cuit = cuit;
       this.companyschedules = companyschedules;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPhone() {
        return this.phone;
    }
    
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getCuit() {
        return this.cuit;
    }
    
    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    public Set getCompanyschedules() {
        return this.companyschedules;
    }
    
    public void setCompanyschedules(Set companyschedules) {
        this.companyschedules = companyschedules;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    
}



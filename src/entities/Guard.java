package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Guard implements java.io.Serializable {

    private Integer id;
    private int dni;
    private String firstname;
    private String lastname;
    private Integer phone;
    private boolean gender;
    private String email;
    private Date birthdate;
    private Date registrationdate;
    private Set<Guardpreference> guardpreferences = new HashSet(0);
    //private Set notifications = new HashSet(0);
    private Set<Guardschedule> guardschedules = new HashSet(0);

    public Guard() {
    }

    public Guard(int dni, String firstname, String lastname, boolean gender, Date birthdate) {
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public Guard(int dni, String firstname, String lastname, Integer phone, boolean gender, String email, Date birthdate, Set guardpreferences, Set guardschedules) {
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.birthdate = birthdate;
        this.guardpreferences = guardpreferences;
        this.guardschedules = guardschedules;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return this.phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return this.gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Guardpreference> getGuardpreferences() {
        return this.guardpreferences;
    }

    public void setGuardpreferences(Set guardpreferences) {
        this.guardpreferences = guardpreferences;
    }

    public Set<Guardschedule> getGuardschedules() {
        return this.guardschedules;
    }

    public void setGuardschedules(Set guardschedules) {
        this.guardschedules = guardschedules;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

}

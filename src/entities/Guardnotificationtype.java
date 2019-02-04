package entities;

import java.util.HashSet;
import java.util.Set;

public class Guardnotificationtype implements java.io.Serializable {

    private Integer id;
    private String description;
    private Set guardpreferences = new HashSet(0);

    public Guardnotificationtype() {
    }

    public Guardnotificationtype(String description) {
        this.description = description;
    }

    public Guardnotificationtype(String description, Set guardpreferences) {
        this.description = description;
        this.guardpreferences = guardpreferences;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getGuardpreferences() {
        return this.guardpreferences;
    }

    public void setGuardpreferences(Set guardpreferences) {
        this.guardpreferences = guardpreferences;
    }

}

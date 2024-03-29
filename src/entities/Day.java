package entities;

import java.util.HashSet;
import java.util.Set;

public class Day implements java.io.Serializable {

    private Integer id;
    private String name;
    private Set companyschedules = new HashSet(0);
    private Set guardschedules = new HashSet(0);

    public Day() {
    }

    public Day(String name) {
        this.name = name;
    }

    public Day(String name, Set companyschedules, Set guardschedules) {
        this.name = name;
        this.companyschedules = companyschedules;
        this.guardschedules = guardschedules;
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

    public Set getCompanyschedules() {
        return this.companyschedules;
    }

    public void setCompanyschedules(Set companyschedules) {
        this.companyschedules = companyschedules;
    }

    public Set getGuardschedules() {
        return this.guardschedules;
    }

    public void setGuardschedules(Set guardschedules) {
        this.guardschedules = guardschedules;
    }

}

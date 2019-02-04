package entities;

import java.util.HashSet;
import java.util.Set;

public class Turntype implements java.io.Serializable {

    private Integer id;
    private String name;
    private String timespan;
    private Set companyschedules = new HashSet(0);
    private Set guardschedules = new HashSet(0);

    public Turntype() {
    }

    public Turntype(String name, String timespan) {
        this.name = name;
        this.timespan = timespan;
    }

    public Turntype(String name, String timespan, Set companyschedules, Set guardschedules) {
        this.name = name;
        this.timespan = timespan;
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

    public String getTimespan() {
        return this.timespan;
    }

    public void setTimespan(String timespan) {
        this.timespan = timespan;
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

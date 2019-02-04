package entities;

import java.util.HashSet;
import java.util.Set;

public class Companyschedule implements java.io.Serializable {

    private Integer id;
    private Company company;
    private Day day = new Day();
    private Turntype turntype = new Turntype();
    private Set turns = new HashSet(0);

    public Companyschedule() {
    }

    public Companyschedule(Company company, Day day, Turntype turntype) {
        this.company = company;
        this.day = day;
        this.turntype = turntype;
    }

    public Companyschedule(Company company, Integer turntype, Integer day) {
        this.company = company;
        this.turntype.setId(turntype);
        this.day.setId(day);
    }

    public Companyschedule(Company company, Day day, Turntype turntype, Set turns) {
        this.company = company;
        this.day = day;
        this.turntype = turntype;
        this.turns = turns;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Day getDay() {
        return this.day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Turntype getTurntype() {
        return this.turntype;
    }

    public void setTurntype(Turntype turntype) {
        this.turntype = turntype;
    }

    public Set getTurns() {
        return this.turns;
    }

    public void setTurns(Set turns) {
        this.turns = turns;
    }

}

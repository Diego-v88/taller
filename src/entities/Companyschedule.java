package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Companyschedule implements java.io.Serializable {

    private Integer id;
    private Company company;
    private Day day = new Day();
    private Turntype turntype = new Turntype();
    private Set<Turn> turns = new HashSet(0);
    private Date fechaAlta;
    private Date fechaBaja;
    
    public Companyschedule() {
        this.fechaAlta = new Date();
    }

    public Companyschedule(Company company, Day day, Turntype turntype) {
        this.company = company;
        this.day = day;
        this.turntype = turntype;
        this.fechaAlta = new Date();
    }

    public Companyschedule(Company company, Integer turntype, Integer day) {
        this.company = company;
        this.turntype.setId(turntype);
        this.day.setId(day);
        this.fechaAlta = new Date();
    }

    public Companyschedule(Company company, Day day, Turntype turntype, Set<Turn> turns) {
        this.company = company;
        this.day = day;
        this.turntype = turntype;
        this.turns = turns;
        this.fechaAlta = new Date();
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

    public Set<Turn> getTurns() {
        return this.turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

}

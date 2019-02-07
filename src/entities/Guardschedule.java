package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Guardschedule implements java.io.Serializable {

    private Integer id;
    private Day day = new Day();
    private Guard guard;
    private Turntype turntype = new Turntype();
    private Set<Turn> turns = new HashSet(0);
    private Date fechaAlta;
    private Date fechaBaja;

    public Guardschedule() {
        this.fechaAlta = new Date();
    }

    public Guardschedule(Day day, Guard guard, Turntype turntype) {
        this.day = day;
        this.guard = guard;
        this.turntype = turntype;
        this.fechaAlta = new Date();
    }

    public Guardschedule(Guard guard, Integer turntype, Integer day) {
        this.day.setId(day);
        this.guard = guard;
        this.turntype.setId(turntype);
        this.fechaAlta = new Date();
    }

    public Guardschedule(Day day, Guard guard, Turntype turntype, Set<Turn> turns) {
        this.day = day;
        this.guard = guard;
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

    public Day getDay() {
        return this.day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Guard getGuard() {
        return this.guard;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
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

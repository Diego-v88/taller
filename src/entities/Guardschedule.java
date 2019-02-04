package entities;

import java.util.HashSet;
import java.util.Set;

public class Guardschedule implements java.io.Serializable {

    private Integer id;
    private Day day = new Day();
    private Guard guard;
    private Turntype turntype = new Turntype();
    private Set turns = new HashSet(0);

    public Guardschedule() {
    }

    public Guardschedule(Day day, Guard guard, Turntype turntype) {
        this.day = day;
        this.guard = guard;
        this.turntype = turntype;
    }

    public Guardschedule(Guard guard, Integer turntype, Integer day) {
        this.day.setId(day);
        this.guard = guard;
        this.turntype.setId(turntype);
    }

    public Guardschedule(Day day, Guard guard, Turntype turntype, Set turns) {
        this.day = day;
        this.guard = guard;
        this.turntype = turntype;
        this.turns = turns;
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

    public Set getTurns() {
        return this.turns;
    }

    public void setTurns(Set turns) {
        this.turns = turns;
    }

}

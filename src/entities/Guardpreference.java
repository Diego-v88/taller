package entities;

public class Guardpreference implements java.io.Serializable {

    private Integer id;
    private Guard guard;
    private Guardnotificationtype guardnotificationtype;
    private String description;

    public Guardpreference() {
    }

    public Guardpreference(Guard guard, Guardnotificationtype guardnotificationtype, String description) {
        this.guard = guard;
        this.guardnotificationtype = guardnotificationtype;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Guard getGuard() {
        return this.guard;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }

    public Guardnotificationtype getGuardnotificationtype() {
        return this.guardnotificationtype;
    }

    public void setGuardnotificationtype(Guardnotificationtype guardnotificationtype) {
        this.guardnotificationtype = guardnotificationtype;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

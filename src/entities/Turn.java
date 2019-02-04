package entities;

import java.util.Date;

public class Turn implements java.io.Serializable {

    private Integer id;
    private Companyschedule companyschedule;
    private Guardschedule guardschedule;
    private Date turndate;
    private Date fechaAlta;
    private Date fechaBaja;

    public Turn() {
        fechaAlta = new Date();
    }

    public Turn(Companyschedule companyschedule, Guardschedule guardschedule, Date turndate) {
        this.companyschedule = companyschedule;
        this.guardschedule = guardschedule;
        this.turndate = turndate;
        this.fechaAlta = new Date();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Companyschedule getCompanyschedule() {
        return this.companyschedule;
    }

    public void setCompanyschedule(Companyschedule companyschedule) {
        this.companyschedule = companyschedule;
    }

    public Guardschedule getGuardschedule() {
        return this.guardschedule;
    }

    public void setGuardschedule(Guardschedule guardschedule) {
        this.guardschedule = guardschedule;
    }

    public Date getTurndate() {
        return this.turndate;
    }

    public void setTurndate(Date turndate) {
        this.turndate = turndate;
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

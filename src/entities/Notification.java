package entities;

import java.util.Date;

public class Notification implements java.io.Serializable {

    private Integer id;
    //private Guard guard;
    private Date senddate;
    private Date nextTurns;
    private Date fechaBaja;

    public Notification() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getSenddate() {
        return this.senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getNextTurns() {
        return nextTurns;
    }

    public void setNextTurns(Date nextTurns) {
        this.nextTurns = nextTurns;
    }
    
}

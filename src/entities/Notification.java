package entities;

import java.util.Date;

public class Notification implements java.io.Serializable {

    private Integer id;
    private Guard guard;
    private Date senddate;

    public Notification() {
    }

    public Notification(Guard guard, Date senddate) {
        this.guard = guard;
        this.senddate = senddate;
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

    public Date getSenddate() {
        return this.senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

}

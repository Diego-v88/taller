
package entities;

import java.util.Date;

public class Userlog implements java.io.Serializable{
     private Integer id;
     private Date fechaIngreso;
     private Users user;

    public Userlog() {
        this.fechaIngreso = new Date();
    }

    public Userlog(Users user) {
        this.fechaIngreso = new Date();
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}

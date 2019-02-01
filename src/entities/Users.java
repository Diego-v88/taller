
package entities;

import java.util.HashSet;
import java.util.Set;

public class Users implements java.io.Serializable{
     private Integer id;
     private String username;
     private String password;
     private Set userslog = new HashSet(0);

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getUserslog() {
        return userslog;
    }

    public void setUserslog(Set userslog) {
        this.userslog = userslog;
    }
}


package dao;

import entities.Users;
import java.io.Serializable;


public interface UserDAO extends GenericDAO<Users, Serializable>{
    public boolean checkUser(String usuario, String pass);
}

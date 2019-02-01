
package dao;

import entities.Users;
import java.io.Serializable;
import org.hibernate.Query;
import utils.HibernateUtil;


public class UserDAOImpl extends GenericDAOImpl<Users, Serializable> implements UserDAO {
    
    @Override
    public boolean checkUser(String usuario, String pass) {
        Boolean boolResult = false;
        String sql = "SELECT us FROM Users us WHERE  us.username = :usuario AND us.password = :pass";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("usuario", usuario).setParameter("pass", pass);
        Users resultado = (Users) query.uniqueResult();
        if (resultado != null) {
            boolResult = true;
        } 
        return boolResult;
    }
}

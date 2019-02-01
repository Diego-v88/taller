
package services;

import dao.DAOException;
import dao.UserDAO;
import dao.UserDAOImpl;
import org.hibernate.HibernateException;
import utils.HibernateUtil;


public class UsersServiceImpl implements UsersService{
    private final UserDAO userDAO = new UserDAOImpl();
    
    @Override
    public boolean verifyUser(String username, String password) throws DAOException{
        boolean resultado = false;
        try {
            HibernateUtil.beginTransaction();
            resultado = userDAO.checkUser(username,password);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo verificar al usuario", ex);
        }
        return resultado;
    }
}

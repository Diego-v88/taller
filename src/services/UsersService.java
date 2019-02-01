
package services;

import dao.DAOException;


public interface UsersService {
    public boolean verifyUser(String username, String password) throws DAOException;
}

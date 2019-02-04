/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DAOException;
import entities.Guard;
import java.util.List;

public interface GuardService {
    
    public Guard getGuardByFullname(String nombre, String apellido) throws DAOException;
 
    public List<Guard> getGuards() throws DAOException;
 
    public void createGuard(Guard guard) throws DAOException;
 
    public Guard getGuardById(Integer id) throws DAOException;
 
    public void deleteGuard(Guard guard) throws DAOException;
    
    public List<Guard> getGuardWithTurns() throws DAOException;
}

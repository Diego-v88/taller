/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DAOException;
import dao.GuardDAO;
import dao.GuardDAOImpl;
import entities.Guard;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import utils.HibernateUtil;


public class GuardServiceImpl implements GuardService {
    
    private final GuardDAO guardDAO = new GuardDAOImpl();

    public GuardServiceImpl() {
    }
    
    @Override
    public Guard getGuardByFullname(String firstName, String lastName) throws DAOException{
        Guard Guard = null;
        try {
            HibernateUtil.beginTransaction();
            Guard = guardDAO.getGuardByFullname(firstName, lastName);
            HibernateUtil.commitTransaction();
        } catch (NonUniqueResultException ex) {
            throw new DAOException("Error en base de datos: Hubo mas de un resultado", ex);
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo traer el Guard", ex);
        }
        
        return Guard;
    }
    
    @Override
    public List<Guard> getGuards() throws DAOException{
        List<Guard> guards = new ArrayList<>();
        try {
            HibernateUtil.beginTransaction();
            guards = guardDAO.findAll(Guard.class);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.print(ex.getMessage());
            throw new DAOException("Error en base de datos: no se pudieron traer los Guards", ex);
        }
        return guards;
    }
    
    @Override
    public void createGuard(Guard guard) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            guardDAO.save(guard);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo crear el nuevo Guard", ex);
        }
    }
    
    @Override
    public Guard getGuardById(Integer id) throws DAOException{
        Guard guard = null;
        try {
            HibernateUtil.beginTransaction();
            guard = guardDAO.findByID(Guard.class, id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo traer al Guard por DNI", ex);
        }
        return guard;
    }
    
    @Override
    public void deleteGuard(Guard guard) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            guardDAO.delete(guard);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo eliminar el Guard", ex);
        }
    }
    
    @Override
    public List<Guard> getGuardWithTurns() throws DAOException{
        List<Guard> guards = null;
        try {
            HibernateUtil.beginTransaction();
            guards = guardDAO.getGuardWithTurns();
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo traer los guardias solicitados", ex);
        }
        return guards;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import dao.DAOException;
import dao.GuardPreferenceDAO;
import dao.GuardPreferenceDAOImpl;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

/**
 *
 * @author argus
 */
public class GuardPreferenceServiceImpl implements GuardPreferenceService {
    
    private final GuardPreferenceDAO guardPreferenceDAO = new GuardPreferenceDAOImpl();

    public GuardPreferenceServiceImpl() {
    }
    
    
    @Override
    public void deleteAll(Integer idGuard) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            guardPreferenceDAO.deleteAll(idGuard);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudieron eliminar las preferencias del guardia", ex);
        }
    }
    
}

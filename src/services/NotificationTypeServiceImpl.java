/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOException;
import dao.NotificationTypeDAO;
import dao.NotificationTypeDAOImpl;
import entities.Guardnotificationtype;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

/**
 *
 * @author argus
 */
public class NotificationTypeServiceImpl implements NotificationTypeService {
    
    private final NotificationTypeDAO notificationTypeDAO = new NotificationTypeDAOImpl();
    
    public NotificationTypeServiceImpl() {
    }
    
    @Override
    public Guardnotificationtype getNotificationTypeById(Integer id) throws DAOException{
        Guardnotificationtype notificationtype = null;
        try {
            HibernateUtil.beginTransaction();
            notificationtype = notificationTypeDAO.findByID(Guardnotificationtype.class, id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo traer el tipo de notificacion", ex);
        }
        return notificationtype;
    }
}

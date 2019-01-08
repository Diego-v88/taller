/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOException;
import entities.Guardnotificationtype;

/**
 *
 * @author argus
 */
public interface NotificationTypeService {
    
    public Guardnotificationtype getNotificationTypeById(Integer id) throws DAOException;
}

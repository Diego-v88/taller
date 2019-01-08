/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Guardschedule;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author argus
 */
public interface GuardScheduleDAO extends GenericDAO<Guardschedule, Serializable>{
    
    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException;
    
    public void deleteAll(Integer guardId) throws DAOException;
}

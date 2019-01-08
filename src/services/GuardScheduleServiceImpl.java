/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DAOException;
import dao.GuardScheduleDAO;
import dao.GuardScheduleDAOImpl;
import entities.Guardschedule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

/**
 *
 * @author arguser
 */
public class GuardScheduleServiceImpl implements GuardScheduleService {
    
    private final GuardScheduleDAO GuardScheduleDAO = new GuardScheduleDAOImpl();
    
    @Override
    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException{
        List<Guardschedule> schedules = new ArrayList<>();
        
        try {
            HibernateUtil.beginTransaction();
            schedules = GuardScheduleDAO.getGuardSchedules(guardId);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Schedules", ex);
        }
        
        return schedules;
    }
    
    @Override
    public void createGuardSchedule(Guardschedule schedule) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            GuardScheduleDAO.save(schedule);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar el nuevo Schedule", ex);
        }
    }
    
    @Override
    public void createGuardScheduleList(List<Guardschedule> schedules) throws DAOException{
        try {
            
            schedules.forEach(schedule -> {
                HibernateUtil.beginTransaction();
                GuardScheduleDAO.save(schedule);
                HibernateUtil.commitTransaction();
            });
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar el nuevo Schedule", ex);
        }
    }
    
    @Override
    public void deleteAll(Integer guardId) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            GuardScheduleDAO.deleteAll(guardId);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo traer los Schedules", ex);
        }
    }
}

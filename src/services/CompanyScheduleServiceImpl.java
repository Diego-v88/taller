/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CompanyScheduleDAO;
import dao.CompanyScheduleDAOImpl;
import dao.DAOException;
import entities.Companyschedule;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

/**
 *
 * @author argus
 */
public class CompanyScheduleServiceImpl implements CompanyScheduleService{
    private final CompanyScheduleDAO CompanyScheduleDAO = new CompanyScheduleDAOImpl();
    
    @Override
    public void createCompanySchedule(Companyschedule schedule) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            CompanyScheduleDAO.save(schedule);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar el nuevo Schedule", ex);
        }
    }
    
    @Override
    public void createCompanyScheduleList(List<Companyschedule> schedules) throws DAOException{
        try {
            schedules.forEach(schedule -> {
                HibernateUtil.beginTransaction();
                CompanyScheduleDAO.save(schedule);
                HibernateUtil.commitTransaction();
            });
            
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar el nuevo Schedule", ex);
        }
    }
    @Override
    public void deleteAll(Integer companyId) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            CompanyScheduleDAO.deleteAll(companyId);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo traer los Schedules", ex);
        }
    }
    
    @Override
    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException{
        List<Companyschedule> schedules = new ArrayList<>();
        
        try {
            HibernateUtil.beginTransaction();
            schedules = CompanyScheduleDAO.getCompanySchedules(companyId);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Schedules", ex);
        }
        return schedules;
    }
}

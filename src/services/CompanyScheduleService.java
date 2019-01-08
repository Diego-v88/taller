/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOException;
import entities.Companyschedule;
import java.util.List;

/**
 *
 * @author argus
 */
public interface CompanyScheduleService  {
    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException;
    
    public void createCompanySchedule(Companyschedule schedule) throws DAOException;
    
    public void createCompanyScheduleList(List<Companyschedule> schedules) throws DAOException;
    
    public void deleteAll(Integer companyId) throws DAOException;    
}

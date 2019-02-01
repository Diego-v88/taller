/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Companyschedule;
import entities.Day;
import entities.Turntype;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author arguser
 */
public interface CompanyScheduleDAO extends GenericDAO<Companyschedule, Serializable> {
    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException;
    
    public void deleteAll(Integer companyId) throws DAOException;
    public List<Companyschedule> getCompanySchedulesByDayAndTt(Day dia, Turntype turnt);
    public int getCompanyAvailability(Day day);
}

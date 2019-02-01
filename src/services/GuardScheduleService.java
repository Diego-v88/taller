/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DAOException;
import entities.Day;
import entities.Guardschedule;
import entities.Turntype;
import java.util.List;

/**
 *
 * @author arguser
 */
public interface GuardScheduleService {
    
    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException;
    
    public void createGuardSchedule(Guardschedule schedule) throws DAOException;
    
    public void createGuardScheduleList(List<Guardschedule> schedule) throws DAOException;
    
    public void deleteAll(Integer guardId) throws DAOException;
    
    public List<Guardschedule> getGuardSchedulesByDayAndTt(Day dia, Turntype turnt) throws DAOException;
    
    public int getGuardAvailability(Day day) throws DAOException;
}

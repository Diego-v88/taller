package dao;

import entities.Day;
import entities.Guard;
import entities.Guardschedule;
import entities.Turntype;
import java.io.Serializable;
import java.util.List;

public interface GuardScheduleDAO extends GenericDAO<Guardschedule, Serializable> {

    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException;

    public void deleteAll(Integer guardId) throws DAOException;

    public List<Guardschedule> getGuardSchedulesByDayAndTt(Day dia, Turntype turnt);

    public int getGuardAvailability(Day day);
    
    public List<Guard> getGuardsScheduleDay(Day dia);
}

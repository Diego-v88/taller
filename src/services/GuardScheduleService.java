package services;

import dao.DAOException;
import entities.Day;
import entities.Guard;
import entities.Guardschedule;
import entities.Turntype;
import java.util.List;

public interface GuardScheduleService {

    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException;

    public void createGuardSchedule(Guardschedule schedule) throws DAOException;

    public void createGuardScheduleList(List<Guardschedule> schedule) throws DAOException;

    public void deleteAll(Integer guardId) throws DAOException;

    public List<Guardschedule> getGuardSchedulesByDayAndTt(Day dia, Turntype turnt) throws DAOException;

    public int getGuardAvailability(Day day) throws DAOException;

    public List<Guard> getGuardsScheduleDay(Day dia) throws DAOException;

    public void bajaAll(Integer guardId) throws DAOException;
}

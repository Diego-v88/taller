package dao;

import entities.Companyschedule;
import entities.Day;
import entities.Turntype;
import java.io.Serializable;
import java.util.List;

public interface CompanyScheduleDAO extends GenericDAO<Companyschedule, Serializable> {

    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException;

    public void deleteAll(Integer companyId) throws DAOException;

    public List<Companyschedule> getCompanySchedulesByDayAndTt(Day dia, Turntype turnt);

    public int getCompanyAvailability(Day day);
}

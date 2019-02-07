package services;

import dao.DAOException;
import dao.GuardDAO;
import dao.GuardDAOImpl;
import dao.GuardScheduleDAO;
import dao.GuardScheduleDAOImpl;
import entities.Day;
import entities.Guard;
import entities.Guardschedule;
import entities.Turntype;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

public class GuardScheduleServiceImpl implements GuardScheduleService {

    private final GuardScheduleDAO GuardScheduleDAO = new GuardScheduleDAOImpl();
    private final GuardDAO guardDAO = new GuardDAOImpl();

    @Override
    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException {
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
    public void createGuardSchedule(Guardschedule schedule) throws DAOException {
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
    public void createGuardScheduleList(List<Guardschedule> schedules) throws DAOException {
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
    public void deleteAll(Integer guardId) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            GuardScheduleDAO.deleteAll(guardId);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo traer los Schedules", ex);
        }
    }
    
    @Override
    public void bajaAll(Integer guardId) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            List<Guardschedule> gchList = GuardScheduleDAO.getGuardSchedules(guardId);
            for (Guardschedule guardschedule : gchList) {
                guardschedule.setFechaBaja(new Date());
            }
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo traer los Schedules", ex);
        }
    }

    @Override
    public List<Guardschedule> getGuardSchedulesByDayAndTt(Day dia, Turntype turnt) throws DAOException {
        List<Guardschedule> schedules = new ArrayList<>();

        try {
            HibernateUtil.beginTransaction();
            schedules = GuardScheduleDAO.getGuardSchedulesByDayAndTt(dia, turnt);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Schedules", ex);
        }

        return schedules;
    }

    @Override
    public int getGuardAvailability(Day day) throws DAOException {
        int resultado = 0;
        try {
            HibernateUtil.beginTransaction();
            resultado = GuardScheduleDAO.getGuardAvailability(day);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo calcular la disponibilidad horaria", ex);
        }
        return resultado;
    }

    @Override
    public List<Guard> getGuardsScheduleDay(Day dia) throws DAOException {
        List<Guard> guards = new ArrayList<>();

        try {
            HibernateUtil.beginTransaction();
            guards = GuardScheduleDAO.getGuardsScheduleDay(dia);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los guardias", ex);
        }

        return guards;
    }
}

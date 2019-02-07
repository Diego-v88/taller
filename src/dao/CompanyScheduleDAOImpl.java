package dao;

import entities.Companyschedule;
import entities.Day;
import entities.Turntype;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;

public class CompanyScheduleDAOImpl extends GenericDAOImpl<Companyschedule, Serializable> implements CompanyScheduleDAO {

    @Override
    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException {
        String sql = "SELECT p FROM Companyschedule p WHERE p.company.id = :companyId AND p.fechaBaja = null";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("companyId", companyId);
        List<Companyschedule> scheduleList = (List<Companyschedule>) query.list();
        return scheduleList;
    }

    @Override
    public void deleteAll(Integer companyId) {
        String sql = "SELECT p FROM Companyschedule p WHERE p.company.id = :companyId";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("companyId", companyId);
        List<Companyschedule> scheduleList = (List<Companyschedule>) query.list();
        if (!scheduleList.isEmpty()) {
            scheduleList.forEach(preference -> {
                HibernateUtil.getSession().delete(preference);
            });
        }
    }

    @Override
    public List<Companyschedule> getCompanySchedulesByDayAndTt(Day dia, Turntype turnt) {
        String sql = "SELECT p FROM Companyschedule p WHERE p.day.id = :dayId AND p.turntype.id = :turntId AND p.fechaBaja = null";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("dayId", dia.getId())
                .setParameter("turntId", turnt.getId());
        List<Companyschedule> scheduleList = (List<Companyschedule>) query.list();
        return scheduleList;
    }

    @Override
    public int getCompanyAvailability(Day day) {
        String sql = "SELECT COUNT(*) FROM Companyschedule p WHERE p.day.id = :dayId AND p.fechaBaja = null";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("dayId", day.getId());
        long scheduleList = (long) query.uniqueResult();
        return (int) scheduleList;
    }
}

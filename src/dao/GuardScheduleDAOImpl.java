
package dao;

import entities.Day;
import entities.Guardschedule;
import entities.Turntype;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;


public class GuardScheduleDAOImpl extends GenericDAOImpl<Guardschedule, Serializable> implements GuardScheduleDAO {
    
    @Override
    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException {
        String sql = "SELECT p FROM Guardschedule p WHERE p.guard.id = :guardId";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("guardId", guardId);
        List<Guardschedule> scheduleList = (List<Guardschedule>) query.list();
        return scheduleList;
    }
    
    @Override
    public void deleteAll(Integer idGuard) {
        String sql = "SELECT p FROM Guardschedule p WHERE p.guard.id = :guardId";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("guardId", idGuard);
        List<Guardschedule> scheduleList = (List<Guardschedule>) query.list();
        if (!scheduleList.isEmpty()) {
            scheduleList.forEach(preference -> {
                HibernateUtil.getSession().delete(preference);
            });
        }
    }
    
    @Override
    public List<Guardschedule> getGuardSchedulesByDayAndTt(Day dia, Turntype turnt) {
        String sql = "SELECT p FROM Guardschedule p WHERE p.day.id = :dayId AND p.turntype.id = :turntId";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("dayId", dia.getId())
                .setParameter("turntId", turnt.getId());
        List<Guardschedule> scheduleList = (List<Guardschedule>) query.list();
        return scheduleList;
    }
    
    @Override
    public int getGuardAvailability(Day day) {
        String sql = "SELECT COUNT(*) FROM Guardschedule p WHERE p.day.id = :dayId";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("dayId", day.getId());
        long scheduleList = (long) query.uniqueResult();
        return (int) scheduleList;
    }
}

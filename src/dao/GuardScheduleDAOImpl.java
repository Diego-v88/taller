/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Guardschedule;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;

/**
 *
 * @author argus
 */
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
}

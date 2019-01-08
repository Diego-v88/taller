/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Companyschedule;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;

/**
 *
 * @author arguser
 */
public class CompanyScheduleDAOImpl extends GenericDAOImpl<Companyschedule, Serializable> implements CompanyScheduleDAO {
    @Override
    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException {
        String sql = "SELECT p FROM Companyschedule p WHERE p.company.id = :companyId";
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
}

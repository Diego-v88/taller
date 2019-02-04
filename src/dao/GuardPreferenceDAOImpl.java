package dao;

import entities.Guardpreference;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;

public class GuardPreferenceDAOImpl extends GenericDAOImpl<Guardpreference, Serializable> implements GuardPreferenceDAO {

    @Override
    public void deleteAll(Integer idGuard) {
        String sql = "SELECT p FROM Guardpreference p WHERE p.guard.id = :idGuard";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("idGuard", idGuard);
        List<Guardpreference> preferenceList = (List<Guardpreference>) query.list();
        if (!preferenceList.isEmpty()) {
            preferenceList.forEach(preference -> {
                HibernateUtil.getSession().delete(preference);
            });
        }
    }

}

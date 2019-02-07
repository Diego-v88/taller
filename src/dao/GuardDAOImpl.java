package dao;

import entities.Guard;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;

public class GuardDAOImpl extends GenericDAOImpl<Guard, Integer> implements GuardDAO {

    @Override
    public Guard getGuardByFullname(String firstName, String lastName) {
        Guard guard = null;
        String sql = "SELECT p FROM Guard p WHERE p.nombre = :nombre AND p.apellido = :apellido";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("nombre", firstName).setParameter("apellido", lastName);
        guard = findOne(query);
        return guard;
    }

    @Override
    public List<Guard> getGuardWithTurns() {
        List<Guard> guards = null;
        String sql = "SELECT p FROM Guard p, Turn t, Guardschedule gs WHERE t.fechaBaja = null AND t.guardschedule.id = gs.id AND gs.guard.id = p.id AND gs.fechaBaja = null GROUP BY p.id";
        Query query = HibernateUtil.getSession().createQuery(sql);
        guards = query.list();
        return guards;
    }
}

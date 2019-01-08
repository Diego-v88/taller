 package dao;

import entities.Guard;
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

}

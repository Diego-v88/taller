package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public void save(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.saveOrUpdate(entity);
    }

    @Override
    public void merge(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.merge(entity);
    }

    @Override
    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }

    @Override
    public List<T> findMany(Query query) {
        List<T> t;
        t = (List<T>) query.list();
        return t;
    }

    @Override
    public T findOne(Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
    }

    @Override
    public T findByID(Class type, Integer id) {
        Session hibernateSession = this.getSession();
        return (T) hibernateSession.get(type, id);
    }

    @Override
    public List findAll(Class cls) {
        Session hibernateSession = this.getSession();
        List T = null;
        Query query = hibernateSession.createQuery("FROM " + cls.getName());
        T = query.list();
        return T;
    }
}

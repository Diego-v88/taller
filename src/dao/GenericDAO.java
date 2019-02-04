package dao;

import java.io.*;
import java.util.*;
import org.hibernate.Query;

public interface GenericDAO<T, ID extends Serializable> {

    public void save(T entity);

    public void merge(T entity);

    public void delete(T entity);

    public List<T> findMany(Query query);

    public T findOne(Query query);

    public List findAll(Class cls);

    public T findByID(Class cls, Integer id);
}

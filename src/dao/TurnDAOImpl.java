package dao;

import entities.Company;
import entities.Guard;
import entities.Turn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import utils.HibernateUtil;

public class TurnDAOImpl extends GenericDAOImpl<Turn, Serializable> implements TurnDAO {

    @Override
    public List<Turn> getTurnsByGuard(Guard guard) {
        int dni = guard.getDni();
        List<Turn> turnsByGuard = new ArrayList<>();
        String sql = "SELECT p FROM Turn p WHERE p.fechaBaja = null AND p.guardschedule.guard.dni = :dni";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("dni", dni);
        turnsByGuard = findMany(query);
        return turnsByGuard;
    }

    @Override
    public List<Turn> getAllTurns() {
        List<Turn> turns = new ArrayList<>();
        String sql = "SELECT p FROM Turn p WHERE p.fechaBaja = null";
        Query query = HibernateUtil.getSession().createQuery(sql);
        turns = findMany(query);
        return turns;
    }
    
    @Override
    public List<Turn> getTurnsByCompany(Company company) {
        int emp = company.getCuit();
        List<Turn> turnsByCompany = new ArrayList<>();
        String sql = "SELECT p FROM Turn p WHERE p.fechaBaja = null AND p.Company = :emp";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("emp", emp);
        turnsByCompany = findMany(query);
        return turnsByCompany;
    }
}
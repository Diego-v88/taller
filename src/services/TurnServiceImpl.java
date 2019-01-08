package services;

import dao.DAOException;
import dao.TurnDAO;
import dao.TurnDAOImpl;
import entities.Company;
import entities.Guard;
import entities.Turn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

/**
 *
 * @author arguser
 */
public class TurnServiceImpl implements TurnService {

    private final TurnDAO TurnDAO = new TurnDAOImpl();

    @Override
    public List<Turn> getTurns() throws DAOException{
        List<Turn> turns = new ArrayList<>();

        try {
            HibernateUtil.beginTransaction();
            turns = TurnDAO.findAll(Turn.class);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Turns ", ex);
        }
        return turns;
    }

    @Override
    public List<Turn> getTurnsByGuard(Guard guard) throws DAOException{
        List<Turn> turnsByGuard = new ArrayList<>();

        try {
            HibernateUtil.beginTransaction();
            turnsByGuard = TurnDAO.getTurnsByGuard(guard);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Turnos", ex);
        }
        return turnsByGuard;
    }

    @Override
    public List<Turn> getTurnsByCompany(Company company) throws DAOException{
        List<Turn> turnByCompany = new ArrayList<>();

        try {
            HibernateUtil.beginTransaction();
            turnByCompany = TurnDAO.getTurnsByCompany(company);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Turns", ex);
        }
        return turnByCompany;
    }

    @Override
    public void createTurn(Turn turn) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            TurnDAO.save(turn);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar un nuevo Turn", ex);
        }
    }

    @Override
    public void deleteTurn(Turn turn) throws DAOException{
        try {
            HibernateUtil.beginTransaction();
            TurnDAO.delete(turn);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo eliminar el Turn", ex);
            
        }
    }
}

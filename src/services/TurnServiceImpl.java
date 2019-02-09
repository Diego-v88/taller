package services;

import dao.DAOException;
import dao.DayDAO;
import dao.DayDAOImpl;
import dao.TurnDAO;
import dao.TurnDAOImpl;
import dao.TurntypeDAO;
import dao.TurntypeDAOImpl;
import entities.Company;
import entities.Day;
import entities.Guard;
import entities.Turn;
import entities.Turntype;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

public class TurnServiceImpl implements TurnService {

    private final TurnDAO TurnDAO = new TurnDAOImpl();
    private final TurntypeDAO turntypeDAO = new TurntypeDAOImpl();
    private final DayDAO dayDAO = new DayDAOImpl();

    @Override
    public List<Turn> getTurns() throws DAOException {
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
    public List<Turn> getTurnsByGuard(Guard guard) throws DAOException {
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
    public boolean activeTurnsByGuard(Guard guard) throws DAOException {
        List<Turn> turnsByGuard = new ArrayList<>();

        try {
            HibernateUtil.beginTransaction();
            turnsByGuard = TurnDAO.getTurnsByGuard(guard);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudieron traer los Turnos", ex);
        }
        return (turnsByGuard.size() > 0);
    }

    @Override
    public void createTurns(List<Turn> turns) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            for (Turn turn : turns) {
                TurnDAO.save(turn);
            }
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo crear el turno", ex);
        }
    }
    
    @Override
    public void sendDateTurns(List<Turn> turns) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            for (Turn turn : turns) {
                Turn turno = TurnDAO.findByID(Turn.class, turn.getId());
                turno.setSenddate(new Date());
            }
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo crear el turno", ex);
        }
    }

    @Override
    public List<Turn> getTurnsByCompany(Company company) throws DAOException {
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
    public void createTurn(Turn turn) throws DAOException {
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
    public void bajaAllTurns() throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            List<Turn> turns = new ArrayList<>();
            turns = TurnDAO.getAllTurns();
            for (Turn turn : turns) {
                turn.setFechaBaja(new Date());
            }
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar un nuevo Turn", ex);
        }
    }
    
    @Override
    public void bajaAllActiveTurnsByDate(Date date) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            List<Turn> turns = new ArrayList<>();
            turns = TurnDAO.getAllTurns();
            for (Turn turn : turns) {
                if (turn.getTurndate().before(date)) {
                    turn.setFechaBaja(new Date());
                }
            }
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar un nuevo Turn", ex);
        }
    }

    @Override
    public void deleteTurn(Turn turn) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            TurnDAO.delete(turn);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo eliminar el Turn", ex);

        }
    }

    @Override
    public List<Turntype> getTurnsType() throws DAOException {
        List<Turntype> turns = new ArrayList<>();
        try {
            HibernateUtil.beginTransaction();
            turns = turntypeDAO.findAll(Turntype.class);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            Logger.getLogger(TurnServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error en base de datos: no se pudieron traer los TurnType ", ex);
        }
        return turns;
    }

    @Override
    public List<Day> getDays() throws DAOException {
        List<Day> days = new ArrayList<>();
        try {
            HibernateUtil.beginTransaction();
            days = dayDAO.findAll(Day.class);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            Logger.getLogger(TurnServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error en base de datos: no se pudieron traer los dias ", ex);
        }
        return days;
    }
}

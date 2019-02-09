
package services;

import dao.DAOException;
import entities.Company;
import entities.Day;
import entities.Guard;
import entities.Turn;
import entities.Turntype;
import java.util.Date;
import java.util.List;


public interface TurnService {

    public List<Turn> getTurns() throws DAOException;

    public List<Turn> getTurnsByGuard(Guard guard) throws DAOException;

    public List<Turn> getTurnsByCompany(Company company) throws DAOException;

    public void createTurn(Turn turn) throws DAOException;

    public void deleteTurn(Turn turn) throws DAOException;
    
    public List<Turntype> getTurnsType() throws DAOException;
    
    public List<Day> getDays() throws DAOException;
    
    public void createTurns(List<Turn> turns) throws DAOException;
    
    public void sendDateTurns(List<Turn> turns) throws DAOException;
    
    public void bajaAllTurns() throws DAOException;
    
    public boolean activeTurnsByGuard(Guard guard) throws DAOException;
    
    public void bajaAllActiveTurnsByDate(Date date) throws DAOException;
}

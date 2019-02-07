package dao;

import entities.Company;
import entities.Guard;
import entities.Turn;
import java.io.Serializable;
import java.util.List;

public interface TurnDAO extends GenericDAO<Turn, Serializable> {

    public List<Turn> getTurnsByGuard(Guard guard);

    public List<Turn> getTurnsByCompany(Company company);
    
    public List<Turn> getAllTurns();
}

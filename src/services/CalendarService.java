package services;

import dao.DAOException;
import entities.Guard;
import entities.Turn;
import java.util.List;

public interface CalendarService {

    public void addEvents(Guard guard, List<Turn> turns) throws DAOException;
}

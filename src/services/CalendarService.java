/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOException;
import entities.Guard;
import entities.Turn;
import java.util.List;

/**
 *
 * @author argus
 */
public interface CalendarService {

    public void addEvents(Guard guard, List<Turn> turns) throws DAOException;
}

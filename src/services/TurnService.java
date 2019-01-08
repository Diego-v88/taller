/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOException;
import entities.Company;
import entities.Guard;
import entities.Turn;
import java.util.List;

/**
 *
 * @author arguser
 */
public interface TurnService {

    public List<Turn> getTurns() throws DAOException;

    public List<Turn> getTurnsByGuard(Guard guard) throws DAOException;

    public List<Turn> getTurnsByCompany(Company company) throws DAOException;

    public void createTurn(Turn turn) throws DAOException;

    public void deleteTurn(Turn turn) throws DAOException;
}

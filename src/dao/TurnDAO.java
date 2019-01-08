/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Company;
import entities.Guard;
import entities.Turn;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author arguser
 */
public interface TurnDAO extends GenericDAO<Turn, Serializable> {

    public List<Turn> getTurnsByGuard(Guard guard);

    public List<Turn> getTurnsByCompany(Company company);
}

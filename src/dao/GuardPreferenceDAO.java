/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Guard;
import entities.Guardpreference;
import java.io.Serializable;

/**
 *
 * @author argus
 */
public interface GuardPreferenceDAO extends GenericDAO<Guardpreference, Serializable>{

    public void deleteAll(Integer idGuard);
    
}

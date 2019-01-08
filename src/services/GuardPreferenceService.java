/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOException;

/**
 *
 * @author argus
 */
public interface GuardPreferenceService {
    public void deleteAll(Integer idGuard) throws DAOException;
}

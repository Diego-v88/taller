/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.DAOException;
import entities.Company;
import java.util.List;

/**
 * 
 * @author arguser
 */
public interface CompanyService {
    
    public List<Company> getCompanies() throws DAOException;
    
    public Company getCompanyById(Integer id) throws DAOException;
 
    public void createCompany(Company company) throws DAOException;
  
    public void deleteCompany(Company company) throws DAOException;
}

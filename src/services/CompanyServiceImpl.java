package services;

import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.DAOException;
import entities.Company;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utils.HibernateUtil;

/**
 *
 * @author 
 */
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO = new CompanyDAOImpl();

    @Override
    public List<Company> getCompanies() throws DAOException {
        List<Company> companies = new ArrayList<>();
        try {
            HibernateUtil.beginTransaction();
            companies = companyDAO.findAll(Company.class);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo traer Companias", ex);
        }
        return companies;
    }

    @Override
    public void createCompany(Company company) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            companyDAO.save(company);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo guardar la Companias", ex);

        }
    }

    @Override
    public Company getCompanyById(Integer id) throws DAOException {
        Company company = null;
        try {
            HibernateUtil.beginTransaction();
            company = companyDAO.findByID(Company.class, id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            throw new DAOException("Error en base de datos: no se pudo traer la Companias", ex);
        }
        return company;
    }

    @Override
    public void deleteCompany(Company company) throws DAOException {
        try {
            HibernateUtil.beginTransaction();
            companyDAO.delete(company);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw new DAOException("Error en base de datos: no se pudo eliminar la Companias", ex);

        }
    }
}

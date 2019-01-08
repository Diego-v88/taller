package dao;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public static DAOFactory getInstance() {
        if (DAOFactory.daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return DAOFactory.daoFactory;
    }
    
    public TurnDAO getTurnDAO() {
        return new TurnDAOImpl();
    }

    public CompanyScheduleDAO getScheduleDAO() {
        return new CompanyScheduleDAOImpl();
    }

    public GuardDAO getGuardDAO() {
        return new GuardDAOImpl();
    }

    public CompanyDAO getCompanyDAO() {
        return new CompanyDAOImpl();
    }
}

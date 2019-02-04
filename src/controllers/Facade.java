package controllers;

import dao.DAOException;
import entities.Company;
import entities.Companyschedule;
import entities.Day;
import entities.Guard;
import entities.Guardnotificationtype;
import entities.Guardschedule;
import entities.Turn;
import entities.Turntype;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import services.CompanyScheduleService;
import services.CompanyService;
import services.FactoryService;
import services.GuardService;
import services.NotificationTypeService;
import services.GuardPreferenceService;
import services.GuardScheduleService;
import services.TurnService;
import services.UsersService;


public class Facade {

    public Facade() {
    }

    private GuardService guardService = FactoryService.getInstance().getGuardService();
    private CompanyService companyService = FactoryService.getInstance().getCompanyService();
    private NotificationTypeService notificationTypeService = FactoryService.getInstance().getNotificationTypeService();
    private GuardPreferenceService guardPreferenceService = FactoryService.getInstance().getGuardPreferenceService();
    private GuardScheduleService guardScheduleService = FactoryService.getInstance().getGuardScheduleService();
    private CompanyScheduleService companyScheduleService = FactoryService.getInstance().getCompanyScheduleService();
    private TurnService turnService = FactoryService.getInstance().getTurnService();
    private UsersService userService = FactoryService.getInstance().getUserService();

    //Guards
    public void createGuard(Guard guard) throws DAOException {
        guard.setRegistrationdate(new Date());
        try {
            guardService.createGuard(guard);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public Guard getGuardById(Integer id) throws DAOException {
        Guard guard = null;
        try {
            guard = guardService.getGuardById(id);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return guard;
    }

    public Guard getGuardByFullname(String firstName, String lastName) throws DAOException {
        Guard guard = null;
        try {
            guard = guardService.getGuardByFullname(firstName, lastName);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return guard;
    }

    public List<Guard> getGuards() throws DAOException {
        try {
            List<Guard> lista;
            lista = guardService.getGuards();
            return lista;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void deleteGuard(Guard guard) throws DAOException {
        try {
            guardService.deleteGuard(guard);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void deleteAllGuardPreferenceByGuard(Integer idGuard) throws DAOException {
        try {
            guardPreferenceService.deleteAll(idGuard);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public List<Guard> getGuardWithTurns() throws DAOException {
        try {
            List<Guard> guardias = guardService.getGuardWithTurns();
            return guardias;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }
    
    public List<Company> getCompanies() throws DAOException {
        try {
            List<Company> lista;
            lista = companyService.getCompanies();
            return lista;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void createCompany(Company company) throws DAOException {
        company.setRegistrationdate(new Date());
        try {
            companyService.createCompany(company);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public Company getCompanyById(Integer id) throws DAOException {
        Company company = null;
        try {
            company = companyService.getCompanyById(id);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return company;
    }

    public void deleteCompany(Company company) throws DAOException {
        try {
            companyService.deleteCompany(company);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public Guardnotificationtype getNotificationType(Integer id) throws DAOException {
        try {
            return notificationTypeService.getNotificationTypeById(id);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void createGuardSchedules(List<Guardschedule> schedules) throws DAOException {
        try {
            guardScheduleService.createGuardScheduleList(schedules);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void createCompanySchedules(List<Companyschedule> schedules) throws DAOException {
        try {
            companyScheduleService.createCompanyScheduleList(schedules);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public List<Guardschedule> getGuardSchedules(Integer guardId) throws DAOException {
        try {
            List<Guardschedule> guardScheduleList;
            guardScheduleList = guardScheduleService.getGuardSchedules(guardId);
            return guardScheduleList;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void deleteAllGuardSchedulesByGuard(Integer guardId) throws DAOException {
        try {
            guardScheduleService.deleteAll(guardId);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public List<Companyschedule> getCompanySchedules(Integer companyId) throws DAOException {
        try {
            List<Companyschedule> companyScheduleList;
            companyScheduleList = companyScheduleService.getCompanySchedules(companyId);
            return companyScheduleList;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public void deleteAllCompanySchedulesByCompany(Integer companyId) throws DAOException {
        try {
            companyScheduleService.deleteAll(companyId);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public List<Turn> getTurns() throws DAOException {
        try {
            List<Turn> turns;
            turns = turnService.getTurns();
            return turns;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }

    public List<Turn> getTurnsByGuard(Guard guard) throws DAOException {
        try {
            List<Turn> turns = new ArrayList<>();
            turns = turnService.getTurnsByGuard(guard);
            return turns;
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }
    
    public void createTurns(List<Turn> turns) throws DAOException {
        try {
            turnService.createTurns(turns);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
    }
    public List<Turntype> getTurnstype() throws DAOException {
        List<Turntype> turnstype;
        try {
            turnstype = turnService.getTurnsType();
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return turnstype;
    }
    
    public boolean isUser(String username, String password) throws DAOException {
        boolean estado = false;
        try {
            estado = userService.verifyUser(username, password);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return estado;
    }

    public List<Turn> generateTurns(Date fecha) throws DAOException {
        List<Turn> turns = new ArrayList<>();
        List<Day> dias = turnService.getDays();
        List<Turntype> tiposTurnos = turnService.getTurnsType();
        List<List> guardiasTiempo;

        for (Day dia : dias) {
            for (Turntype tiposTurno : tiposTurnos) {
                List<Companyschedule> compDT = companyScheduleService.getCompanySchedulesByDayAndTt(dia, tiposTurno);
                List<Guardschedule> guarDT = guardScheduleService.getGuardSchedulesByDayAndTt(dia, tiposTurno);
                if (compDT.size() > guarDT.size()) {
                    return null;
                } else {
                    for (Companyschedule coso : compDT) {
                        Random rand = new Random();
                        Turn turno = new Turn();
                        Calendar fechaTurno = Calendar.getInstance();
                        fechaTurno.setTime(fecha);
                        fechaTurno.add(Calendar.DATE, dia.getId());
                        Guardschedule guardia = guarDT.get(rand.nextInt(guarDT.size()));
                        //if guardia.getGuard() tiene tiempo
                            turno.setGuardschedule(guardia);
                            turno.setCompanyschedule(coso);
                            turno.setTurndate(fechaTurno.getTime());
                            guarDT.remove(guardia);
                            turns.add(turno);
                            //agregar tiempo del guardia
                        //Sino
                            //return null;
                    }
                }
            }
        }
        return turns;
    }
    
    public int getGuardAvailability(Day day) throws DAOException {
        int resultado = 0;
        try {
            resultado = guardScheduleService.getGuardAvailability(day);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return resultado;
    }
    
    public int getCompanyAvailability(Day day) throws DAOException {
        int resultado = 0;
        try {
            resultado = companyScheduleService.getCompanyAvailability(day);
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return resultado;
    }
    
    public List<Day> getDays() throws DAOException {
        List<Day> dias = null;
        try {
            dias = turnService.getDays();
        } catch (DAOException ex) {
            throw new DAOException(null, ex);
        }
        return dias;
    }
}

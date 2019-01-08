package services;

import entities.Guardnotificationtype;

/**
 *
 * Ejemplo: GestorDeGuards gestorDeGuards =
 * GestorFactory.getInstance().getGestorDeGuard()
 *
 *
 */
public class FactoryService {

    private static FactoryService gestorFactory;

    public static FactoryService getInstance() {
        if (FactoryService.gestorFactory == null) {
            gestorFactory = new FactoryService();
        }
        return FactoryService.gestorFactory;
    }

    public GuardService getGuardService() {
        return new GuardServiceImpl();
    }
    
    public NotificationTypeService getNotificationTypeService() {
        return new NotificationTypeServiceImpl();
    }
    
    public GuardPreferenceService getGuardPreferenceService() {
        return new GuardPreferenceServiceImpl();
    }

    public CompanyService getCompanyService() {
        return new CompanyServiceImpl();
    }

    public GuardScheduleService getGuardScheduleService() {
        return new GuardScheduleServiceImpl();
    }
    
    public CompanyScheduleService getCompanyScheduleService() {
        return new CompanyScheduleServiceImpl();
    }

    public TurnService getTurnService() {
        return new TurnServiceImpl();
    }
}

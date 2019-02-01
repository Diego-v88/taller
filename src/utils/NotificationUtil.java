
package utils;

import controllers.Facade;
import dao.DAOException;
import entities.Guard;
import entities.Guardpreference;
import entities.Turn;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotificationUtil {

    Facade fachada = new Facade();
    SendMail mailinator = new SendMail();
    CalendarUtil calendator = new CalendarUtil();

    public void SendNotifications() {
        try {
            List<Guard> guards = fachada.getGuards();
            if (guards != null && !guards.isEmpty()) {
                guards.forEach(guard -> {
                    try {
                        List<Turn> turns = fachada.getTurnsByGuard(guard);
                        if (turns != null && !turns.isEmpty()) {
                            Set<Guardpreference> guardPreferences = guard.getGuardpreferences();
                            if (guardPreferences != null && !guardPreferences.isEmpty()) {
                                guardPreferences.forEach(preference -> {
                                    int notificationType = (int) preference.getGuardnotificationtype().getId();
                                    switch (notificationType) {
                                        case 2:
                                            mailinator.SendMail(guard, turns);
                                            break;
                                        case 3:
                                            calendator.addEvents(guard, turns);
                                            break;
                                    }
                                });
                            }
                        }
                    } catch (DAOException ex) {
                        Logger.getLogger(NotificationUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });
            }
        } catch (DAOException ex) {
            Logger.getLogger(NotificationUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

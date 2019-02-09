
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

    public NotificationUtil() {
    }
    
    public void SendNotifications() throws DAOException {
            List<Guard> guards = fachada.getGuardWithTurns();
            if (guards != null && !guards.isEmpty()) {
                guards.forEach(guard -> {
                    try {
                        List<Turn> turns = fachada.getTurnsByGuard(guard);
                        turns.removeIf(turn -> turn.getSenddate()!=null);
                        if (turns != null && !turns.isEmpty()) {
                            Set<Guardpreference> guardPreferences = guard.getGuardpreferences();
                            if (guardPreferences != null && !guardPreferences.isEmpty()) {
                                guardPreferences.forEach(preference -> {
                                    try {
                                        int notificationType = (int) preference.getGuardnotificationtype().getId();
                                        switch (notificationType) {
                                            case 2:
                                                mailinator.SendMail(guard, turns);
                                                System.out.println("MAIL");
                                                break;
                                            case 3:
                                                calendator.addEvents(guard, turns);
                                                System.out.println("CALENDARIO");
                                                break;
                                        }
                                        fachada.sendDateTurns(turns);
                                    } catch (DAOException ex) {
                                        Logger.getLogger(NotificationUtil.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            }
                        }
                    } catch (DAOException ex) {
                        Logger.getLogger(NotificationUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });
            }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPruebas;

import controllers.Facade;
import dao.DAOException;
import entities.Guard;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CalendarUtil;

/**
 *
 * @author Diego
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CalendarUtil calendar = new CalendarUtil();
        //calendar.listCalendars();

        /*Date fecha = new Date();
        if (fecha.getDay() != 0) {
            Calendar fechaTurno = Calendar.getInstance();
            fechaTurno.setTime(fecha);
            fechaTurno.add(Calendar.DATE, 7 - fecha.getDay());
            fecha = fechaTurno.getTime();
        }
        System.out.println(fecha.getDay())*/
        Facade fachada = new Facade();
        try {
            
            System.out.println(fachada.getGuardWithTurns().size());
        } catch (DAOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

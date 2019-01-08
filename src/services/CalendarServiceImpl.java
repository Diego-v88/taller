/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Guard;
import entities.Turn;
import java.util.List;
import utils.CalendarUtil;

/**
 *
 * @author argus
 */
public class CalendarServiceImpl implements CalendarService {

    @Override
    public void addEvents(Guard guard, List<Turn> turns) {
        CalendarUtil instance = new CalendarUtil();
        //instance.addEvents(turns);
    }
}

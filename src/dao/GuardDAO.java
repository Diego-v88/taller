package dao;

import entities.Guard;
import java.util.List;


public interface GuardDAO extends GenericDAO<Guard, Integer> {
    
    public Guard getGuardByFullname(String nombre, String apellido);
    public List<Guard> getGuardWithTurns();
    
}

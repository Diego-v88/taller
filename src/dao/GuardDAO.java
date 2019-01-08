package dao;

import entities.Guard;


public interface GuardDAO extends GenericDAO<Guard, Integer> {
    
    public Guard getGuardByFullname(String nombre, String apellido);
    
    
}

package dao;

import entities.Guardpreference;
import java.io.Serializable;

public interface GuardPreferenceDAO extends GenericDAO<Guardpreference, Serializable> {

    public void deleteAll(Integer idGuard);

}

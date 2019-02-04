package dao;

public class DAOException extends Exception {

    public DAOException(String descripcion, Exception excepcion) {
        super(descripcion, excepcion);
    }
}

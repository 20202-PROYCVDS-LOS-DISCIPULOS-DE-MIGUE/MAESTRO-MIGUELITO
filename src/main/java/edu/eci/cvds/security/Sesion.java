package edu.eci.cvds.security;
import edu.eci.cvds.exceptions.PersistenceException;

public interface Sesion {
    public void login(String documento, String contraseña)throws PersistenceException;
    public boolean isLogged();
}

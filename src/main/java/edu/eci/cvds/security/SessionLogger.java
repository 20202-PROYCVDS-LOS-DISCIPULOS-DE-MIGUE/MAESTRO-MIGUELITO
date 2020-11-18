package edu.eci.cvds.security;

import edu.eci.cvds.exceptions.PersistenceException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface SessionLogger {
    public void login(String documento, String contraseña)throws PersistenceException;
    public boolean isLogged();
}

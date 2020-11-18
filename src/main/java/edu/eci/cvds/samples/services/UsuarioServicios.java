package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface UsuarioServicios {
    //public List<Usuario> getUsers() throws PersistenceException;

    public Usuario getUser (String nombre) throws PersistenceException;

    public boolean validateLogin(String nombre, String clave) throws PersistenceException;
}

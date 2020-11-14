package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface UsuarioDAO 
{
    public List<Usuario> consultarUsuarios() throws PersistenceException;
    public boolean guardarUsuario(int documento, String contraseña) throws PersistenceException;
    public Usuario cargarUsuario(int documento, String contraseña) throws PersistenceException;
    
}
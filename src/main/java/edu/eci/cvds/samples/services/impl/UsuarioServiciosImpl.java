package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.UsuarioServicios;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class UsuarioServiciosImpl implements UsuarioServicios{
    @Inject
    private UsuarioDAO usuarioDao;

    /**
    @Override
    public List<Usuario> getUsers() throws PersistenceException {
        return UsuarioDao.getUsers();
    }**/

    @Override
    public Usuario getUser(String nombre) throws PersistenceException {
        return usuarioDao.getUser(nombre);
    }

    @Override
    public boolean validateLogin(String nombre, String clave) throws PersistenceException {
        Usuario usuario=usuarioDao.getUser(nombre);
        if (usuario==null){
            return false;
        }else{
            return true;
        }
    }
    public UsuarioDAO getUserDao(){
        return usuarioDao;
    }
}

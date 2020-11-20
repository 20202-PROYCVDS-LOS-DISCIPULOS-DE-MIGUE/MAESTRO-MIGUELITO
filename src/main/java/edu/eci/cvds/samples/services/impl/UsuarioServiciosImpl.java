package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.UsuarioServicios;
import java.util.List;

public class UsuarioServiciosImpl implements UsuarioServicios{
    @Inject
    private UsuarioDAO usuarioDao;

    /**
    @Override
    public List<Usuario> getUsers() throws PersistenceException {
        return UsuarioDao.getUsers();
    }**/

    @Override
    public Usuario getUser(String documento) throws PersistenceException {
        return usuarioDao.getUser(documento);
    }

    @Override
    public boolean validateLogin(String documento, String contraseña) throws PersistenceException {
        Usuario usuario=usuarioDao.getUser(documento);
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

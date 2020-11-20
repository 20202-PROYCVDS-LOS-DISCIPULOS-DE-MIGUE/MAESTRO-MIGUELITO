package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;

public interface UsuarioDAO {

    //public List<Usuario> getUsers() throws PersistenceException;
    public Usuario getUser(String documento) throws  PersistenceException;
}

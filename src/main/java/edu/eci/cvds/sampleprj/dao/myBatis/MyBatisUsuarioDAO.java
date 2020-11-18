package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.UsuarioMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class MyBatisUsuarioDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;
    /**@Override
    public List<Usuario> getUsers() throws PersistenceException {
        try{
            return UsuarioMapper.getUsers();
        }catch (Exception e){
            throw new PersistenceException("Error consultando usuarios",e);
        }
    }**/

    public UsuarioMapper getUserMapper() {
        return usuarioMapper;
    }

    public void setUserMapper(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario getUser(String nombre) throws PersistenceException {
        try{
            return usuarioMapper.getUser(nombre);
        }catch (Exception e){
            throw new PersistenceException("Error consultando usuario",e);
        }
    }
}

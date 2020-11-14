package edu.eci.cvds.samples.services.impl;
 
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.services.ServiciosUsuario;
import java.util.List;


public class ServicesUserImpl implements ServiciosUsuario
{
    @Inject
    private  UsuarioDAO usuarioDAO;
	
    @Override
    public boolean guardarUsuario(int documento, String contraseña) throws PersistenceException
    {
            try{
                    return usuarioDAO.guardarUsuario(documento,contraseña);
            }catch(PersistenceException  e){
                    throw new PersistenceException("Error guardando usuario",e);
            }
    }
    
    @Override
    public List<Usuario> consultarUsuarios() throws PersistenceException
    {
            try{
                    return usuarioDAO.consultarUsuarios();
            }catch(PersistenceException e){
                    throw new PersistenceException("Error consultando usuario",e);
            }
    }
    
    @Override
    public Usuario cargarUsuario(int documento,String contraseña) throws PersistenceException 
    {
            try{
                    return usuarioDAO.cargarUsuario(documento,contraseña);
            }catch(PersistenceException  e){
                    throw new PersistenceException("Error cargando usuario",e);
            }
    }
}
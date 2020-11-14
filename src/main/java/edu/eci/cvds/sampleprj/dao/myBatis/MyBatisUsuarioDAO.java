/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.UsuarioMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import java.util.List;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class MyBatisUsuarioDAO implements UsuarioDAO
{
    @Inject
    private UsuarioMapper usuarioMapper;
	
    @Override
    public List <Usuario> consultarUsuarios() throws PersistenceException 
    {
        try {
            return usuarioMapper.consultarUsuarios();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando cliente ",e);
        }
    }
	
    @Override
    public boolean guardarUsuario(int documento, String contraseña) throws PersistenceException 
    {
        try {
			Usuario usuario = usuarioMapper.cargarUsuario(documento, contraseña);
			return true;
		} 
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Credenciales invalidas", e); 
			
		}
    }
    
    @Override
    public Usuario cargarUsuario(int documento, String contraseña) throws PersistenceException 
    {
        try {
            return usuarioMapper.cargarUsuario(documento, contraseña);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando cliente.", e); 
		}
    }
}

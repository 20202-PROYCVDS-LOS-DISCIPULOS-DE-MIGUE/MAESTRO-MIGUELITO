package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import java.util.List;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosUsuario 
{
	public List<Usuario> consultarUsuarios() throws PersistenceException;
	public Usuario cargarUsuario(int documento, String contrasena) throws PersistenceException;  
	public boolean guardarUsuario(int documento, String contraseña) throws PersistenceException; 
}